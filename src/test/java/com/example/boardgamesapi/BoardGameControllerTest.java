package com.example.boardgamesapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.Integer.parseInt;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;




import java.util.ArrayList;
import java.util.List;

@WebMvcTest
public class BoardGameControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    GameService gameService;

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
        when(gameService.getAllGames()).thenReturn(boardGameList);

        mockMvc.perform(get("/boardgames"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    public void getSingleGame() throws Exception {
        when(gameService.getSingleGame(0)).thenReturn(boardGameList.get(0));

        mockMvc.perform(get("/boardgames/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Name 0")));
    }

//    @Test
//    public void addGame() throws Exception {
//        BoardGame game = new BoardGame(11, "Name 11", 11, "Descr 11", 11);
//        when(gameService.addGame(game)).thenReturn(game);
//        String gameData = game.toString();
//
//        /*
//            ObjectMapper objectMapper = new ObjectMapper();
//            String gameAsString = objectMapper.writeValueAsString(game);
//        */
//
//        mockMvc.perform(post("/boardgames")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content("{\"id\":11," +
//                            "\"name\":\"Name 11\"," +
//                            "\"playerCount\":11," +
//                            "\"description\":\"Descr 11\"," +
//                            "\"rating\":11}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("name").value("Name 11"));
//    }
}
