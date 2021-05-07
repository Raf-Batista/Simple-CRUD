package com.example.boardgamesapi;

public class BoardGame {
    int id;
    String name;
    int playerCount;
    String description;
    double rating;

    public BoardGame() {
    }

    public BoardGame(int id, String name, int playerCount, String description, double rating) {
        this.id = id;
        this.name = name;
        this.playerCount = playerCount;
        this.description = description;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
