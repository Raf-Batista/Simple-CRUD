package com.example.boardgamesapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class BoardGameController {

    GameService gameService;

    public BoardGameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/boardgames")
    public List<BoardGame> getBoardGames() {
        return gameService.getAllGames();
    }
    @GetMapping("/boardgames/{id}")
    public BoardGame getSingleBoardGame(@PathVariable int id) {
        return gameService.getSingleGame(id);
    }
//    @GetMapping("/boardgames")

}
