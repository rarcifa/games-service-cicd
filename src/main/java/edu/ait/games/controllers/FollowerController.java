package edu.ait.games.controllers;

import edu.ait.games.dto.Follower;
import edu.ait.games.repositories.exceptions.ReviewNotFoundException;
import edu.ait.games.repositories.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FollowerController {

    @Autowired
    FollowerRepository followerRepository;

    // get all Games pageable
    // @GetMapping("items")
    // public Page<Game> getAllGames(Pageable pageable) {
    // return all Games
    // return gamesRepository.findAll(pageable);
    // }

    // get all reviews
    @GetMapping("followers")
    public List<Follower> getAllfoundFollowers() {
        // return all reviews
        return followerRepository.findAll();
    }
    // get reviews by id
    @GetMapping("followers/{id}")
    public Follower getReviewById(@PathVariable int id) {
        // return reviews by id
        Optional<Follower> foundFollower = followerRepository.findById(id);
        if(foundFollower.isPresent())
            return foundFollower.get();
        else
            throw new ReviewNotFoundException("Unable to find Review with id: " + id);
    }

}
