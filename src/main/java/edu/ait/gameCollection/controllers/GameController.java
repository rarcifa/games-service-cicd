package edu.ait.gameCollection.controllers;

import edu.ait.gameCollection.dto.Game;
import edu.ait.gameCollection.repositories.exceptions.GameNotFoundException;
import edu.ait.gameCollection.model.GameModel;
import edu.ait.gameCollection.repositories.GameRepository;
import edu.ait.gameCollection.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameRepository gamesRepository;

    @Autowired
    GameService gameService;

    // get all Games pageable
    // @GetMapping("items")
    // public Page<Game> getAllGames(Pageable pageable) {
    // return all Games
    // return gamesRepository.findAll(pageable);
    // }

    // get all wines
    @GetMapping("games")
    public Page<Game> getAllGames(Pageable pageable) {
        // return all Games
        return gamesRepository.findAll(pageable);
    }

    // get all wines
    @GetMapping("items")
    public List<GameModel> getAllGames() {
        // return all Games
        return gameService.getAllGames();
    }

    // get Game by id
    @GetMapping("items/{id}")
    public Game getGameById(@PathVariable int id) {
        // return Game by id
        Optional<Game> foundGame = gamesRepository.findById(id);
        if(foundGame.isPresent())
            return foundGame.get();
        else 
            throw new GameNotFoundException("Unable to find Game with id: " + id);
    }

}
