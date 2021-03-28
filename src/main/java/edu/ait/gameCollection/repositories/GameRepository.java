package edu.ait.gameCollection.repositories;

import edu.ait.gameCollection.dto.Game;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
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
}
