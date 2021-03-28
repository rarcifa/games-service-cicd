package edu.ait.games.repositories;

import edu.ait.games.dto.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query("SELECT g.id AS gameId, COUNT(f.f_id) AS totalFollower FROM Game g JOIN g.follower f GROUP BY g.id")
    public List<GameFollower> findAllWithFollower();

    @Query("SELECT DISTINCT g FROM Game g LEFT JOIN fetch g.review")
    public List<Game> findAllWithReviews();

    interface GameFollower {
        int getGameId();

        long getTotalFollower();
    }

    // Find by Genre
    Page<Game> findByGenre(String genre, Pageable pageable);

    // Find by Rating
    Page<Game> findByMetascore(String metascore, Pageable pageable);
}
