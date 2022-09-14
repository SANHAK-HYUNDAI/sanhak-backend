package com.sanhak.backend.domain.comment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanhak.backend.domain.comment.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class CommentControllerTest {
    @Mock
    private CommentService commentService;
    @InjectMocks
    private CommentController commentController;

    private MockMvc mockMvc;

    @Spy
    private ObjectMapper objectMapper;

    @BeforeEach
    private void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
    }

    @Test
    @DisplayName("CommentController : Comment가 성공적으로 삭제되었을 때 id 반환")
    void deleteById() throws Exception {
        //given
        Long id = 123456L;
        doReturn(id).when(commentService).deleteById(id);

        //when
        MvcResult res = mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/comment/{id}", id))
                .andReturn();
        Long removedId = objectMapper.readValue(res.getResponse().getContentAsString(), Long.class);

        //then
        assertThat(removedId).isEqualTo(id);
    }
}