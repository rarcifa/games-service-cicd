package edu.ait.games.repositories;

import edu.ait.games.dto.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
