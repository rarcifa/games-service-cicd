package edu.ait.gameCollection.service;

import edu.ait.gameCollection.dto.Game;
import edu.ait.gameCollection.dto.Review;
import edu.ait.gameCollection.model.GameModel;
import edu.ait.gameCollection.repositories.GameRepository;
import edu.ait.gameCollection.repositories.ReviewRepository;
import org.hibernate.jpa.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StopWatch;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GameService {

    @Autowired
    GameRepository gamesRepository;

    @Autowired
    ReviewRepository reviewRepository;

    final List<String> nonNumericScores = List.of("n/a", "nr", "null", "");

    @Transactional
    public List<GameModel> getAllGames() {
        StopWatch watch = new StopWatch();
        watch.start();
        final Map<Integer, Long> gameFollowers =
                gamesRepository.findAllWithFollower().stream()
                        .collect(Collectors.toMap(GameRepository.GameFollower::getGameId,
                                GameRepository.GameFollower::getTotalFollower));
        final List<Game> games = gamesRepository.findAllWithReviews();
        watch.stop();
        System.out.println("Total time taken by spring jpa: "+watch.getTotalTimeMillis()+" milliseconds");
        return games.stream()
                .map(game -> convert(game, gameFollowers))
                .sorted(Comparator.comparingDouble(GameModel::getAverageRating).reversed())
                .sorted(Comparator.comparingDouble(GameModel::getMetascore).reversed())
                .sorted(Comparator.comparingDouble(GameModel::getIgnscore))
                .collect(Collectors.toList());
    }

    private GameModel convert(Game game, Map<Integer, Long> gameFollowers) {
        GameModel gameModel = new GameModel();
        gameModel.setId(game.getId());
        gameModel.setName(game.getName());
        gameModel.setCover(game.getCover());
        gameModel.setConsole(game.getConsole());
        gameModel.setPublisher(game.getPublisher());
        gameModel.setGenre(game.getGenre());
        gameModel.setReleasedate(game.getReleasedate());

        gameModel.setMetascore(ObjectUtils.isEmpty(game.getMetascore()) || nonNumericScores.contains(game.getMetascore().toLowerCase()) ? 0 :
                Double.parseDouble(game.getMetascore()));
        gameModel.setIgnscore(ObjectUtils.isEmpty(game.getIgnscore()) || nonNumericScores.contains(game.getIgnscore().toLowerCase()) ? 0 :
                Double.parseDouble(game.getIgnscore()));
        gameModel.setIgdbscore(ObjectUtils.isEmpty(game.getIgdbscore()) || nonNumericScores.contains(game.getIgdbscore().toLowerCase()) ? 0 :
                Integer.parseInt(game.getIgdbscore()));

        final Supplier<Stream<Integer>> ratingStream = () -> game.getReview().stream().map(Review::getRating);
        gameModel.setAverageRating(ratingStream.get().mapToInt(Integer::intValue).average().orElse(0));
        gameModel.setTotalRating(ratingStream.get().count());

        gameModel.setTotalFollower(gameFollowers.get(game.getId()));

        return gameModel;
    }

}
