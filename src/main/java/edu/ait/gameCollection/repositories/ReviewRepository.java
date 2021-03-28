package edu.ait.gameCollection.repositories;

import edu.ait.gameCollection.dto.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
