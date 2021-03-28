package edu.ait.games.repositories;

import edu.ait.games.dto.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query("SELECT g FROM Game g")
    public List<Game> findAllWithReviews();

    // Find by Genre
    Page<Game> findByGenre(String genre, Pageable pageable);

    // Find by Rating
    Page<Game> findByMetascore(String metascore, Pageable pageable);
}
