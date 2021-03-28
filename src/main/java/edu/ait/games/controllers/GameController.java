package edu.ait.games.controllers;

import edu.ait.games.dto.Game;
import edu.ait.games.repositories.exceptions.GameNotFoundException;
import edu.ait.games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameRepository gamesRepository;

    // get all Games pageable
    @GetMapping(value="/games", produces= MediaType.APPLICATION_JSON_VALUE)
    public Page<Game> getAllGames(Pageable pageable) {
        //return all Games
        return gamesRepository.findAll(pageable);
    }


    // get Game by id
    @GetMapping("games/{id}")
    public Game getGameById(@PathVariable int id) {
        // return Game by id
        Optional<Game> foundGame = gamesRepository.findById(id);
        if(foundGame.isPresent())
            return foundGame.get();
        else
            throw new GameNotFoundException("Unable to find Game with id: " + id);
    }

    //Delete Game by id
    @DeleteMapping("games/{id}")
    public void deleteGameById(@PathVariable int id) {

        try {
            // delete by id
            gamesRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new GameNotFoundException("Unable to delete Game with id:" + id);
        }
    }

}
