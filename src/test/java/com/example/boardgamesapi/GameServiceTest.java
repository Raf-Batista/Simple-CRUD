package com.example.boardgamesapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    GameService gameService;
    List<BoardGame> boardGameList;
    @BeforeEach
    public void setUp() {
        gameService = new GameService();
        boardGameList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            boardGameList.add(new BoardGame(i, "Name " + i, 4, "Description " + i, i % 6));
        }
        gameService.setBoardGameList(boardGameList);
    }

    @Test
    void getAllGames() {
        List<BoardGame> boardgames = gameService.getAllGames();
        assertEquals(boardGameList, boardgames);
    }

    @Test
    void getSingleGame() {
        BoardGame game = gameService.getSingleGame(2);
        BoardGame expected = boardGameList.get(2);
        assertEquals(expected, game);
    }

    @Test
    void addGame() {
    }
}