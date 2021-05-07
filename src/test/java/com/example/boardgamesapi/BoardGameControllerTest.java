package com.example.boardgamesapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;


import java.util.ArrayList;
import java.util.List;

@WebMvcTest
public class BoardGameControllerTest {
    @Autowired
    MockMvc mockMvc;

    List<BoardGame> boardGameList;

    @BeforeEach
    public void setup() {
        boardGameList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            boardGameList.add(new BoardGame(i, "Name " + i, 4, "Description " + i, i % 6));
        }
    }

    @Test
    public void getData() throws Exception {
        mockMvc.perform(get("/boardgames"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)));
    }
}
