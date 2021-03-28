package edu.ait.games.controllers;

import edu.ait.games.dto.Review;
import edu.ait.games.repositories.exceptions.ReviewNotFoundException;
import edu.ait.games.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    // get all Games pageable
    // @GetMapping("items")
    // public Page<Game> getAllGames(Pageable pageable) {
    // return all Games
    // return gamesRepository.findAll(pageable);
    // }

    // get all reviews
    @GetMapping("reviews")
    public List<Review> getAllReviews() {
        // return all reviews
        return reviewRepository.findAll();
    }
    // get reviews by id
    @GetMapping("reviews/{id}")
    public Review getReviewById(@PathVariable int id) {
        // return reviews by id
        Optional<Review> foundReview = reviewRepository.findById(id);
        if(foundReview.isPresent())
            return foundReview.get();
        else 
            throw new ReviewNotFoundException("Unable to find Review with id: " + id);
    }

}
