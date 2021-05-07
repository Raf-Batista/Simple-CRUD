package com.example.boardgamesapi;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

@WebMvcTest
public class BoardgameControllerTest {
    @Autowired
    MockMvc mockMvc;
    List<Boardgame> boardgameList;

    @BeforeEach
    public void setup() {
        boardgameList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            boardgameList.add(new Boardgame(i, "Name " + i, 4, "Description " + i, i % 6));
        }
    }
}
