package edu.ait.games.controllers;

import edu.ait.games.dto.Game;
import edu.ait.games.repositories.exceptions.GameNotFoundException;
import edu.ait.games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    // Create a new Game
    @PostMapping("games/")
    public ResponseEntity createGame(@RequestBody Game newGame) {

        // add the Game
        Game savedGame = gamesRepository.save(newGame);
        // create the location header
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id")
                .buildAndExpand(savedGame.getId()).toUri();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //Step 5: Update an existing Game
    @PutMapping("games/")
    public ResponseEntity updateGame(@RequestBody Game newGame) {

        // update the Game
        if(newGame.getId() != null)
        {
            // simply save the Game
            gamesRepository.save(newGame);
            // just return 200 ok
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else
        {
            // create new Game
            Game savedGame = gamesRepository.save(newGame);
            // create the lcoation header
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("{id}")
                    .buildAndExpand(savedGame.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    // Search for games with a particular genre
    @GetMapping(value="/games/genre/{genre}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Page<Game> getGamesByGenre(@PathVariable String genre, Pageable pageable) {

        Page<Game> gamePage = gamesRepository.findByGenre(genre, pageable);
        return gamePage;

    }

    // Search for games with a particular rating
    @GetMapping(value="/games/score/{metascore}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Page<Game> getGamesByRating(@PathVariable String metascore, Pageable pageable) {

        Page<Game> gamePage = gamesRepository.findByMetascore(metascore, pageable);
        return gamePage;

    }

}
