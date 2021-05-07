package com.example.boardgamesapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    List<BoardGame> boardGameList = new ArrayList<>();

    public List<BoardGame> getAllGames() {
        return boardGameList;
    }

    public BoardGame getSingleGame(int id) {
        for (BoardGame game: boardGameList) {
            if (game.id == id) return game;
        }
        return null;
    }

    public BoardGame addGame(BoardGame game) {
        return null;

    }

    public List<BoardGame> getBoardGameList() {
        return boardGameList;
    }

    public void setBoardGameList(List<BoardGame> boardGameList) {
        this.boardGameList = boardGameList;
    }
}
