package com.sanhak.backend.domain.article.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanhak.backend.domain.article.CafeArticle;
import com.sanhak.backend.domain.article.dto.CAResDTO;
import com.sanhak.backend.domain.article.service.CAService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CAControllerTest {
    @Mock
    private CAService caService;
    @InjectMocks
    private CAController caController;
    @Spy
    private ModelMapper modelMapper;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(caController).build();
    }

    @Test
    @DisplayName("CAController : 성공적으로 CA 를 찾았을 때 CAResDTO 반환")
    void findById() throws Exception {
        // given
        long id = 12345L;
        CafeArticle ca = CafeArticle.builder()
                .id(id)
                .cafeName("cafe name")
                .broadName("broad name")
                .userName("user name")
                .category("category")
                .content("content")
                .period(1)
                .title("title")
                .url("url")
                .viewCount(0L)
                .docCreatedAt(LocalDateTime.now())
                .isMailing(false)
                .build();
        doReturn(ca).when(caService).findById(id);

        // when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/article/naver/{id}", id))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        CAResDTO dto = objectMapper.readValue(content, CAResDTO.class);

        // then
        assertThat(dto.getId()).isEqualTo(ca.getId());
        assertThat(dto.getBroadName()).isEqualTo(ca.getBroadName());
        assertThat(dto.getCafeName()).isEqualTo(ca.getCafeName());
        assertThat(dto.getContent()).isEqualTo(ca.getContent());
        assertThat(dto.getCategory()).isEqualTo(ca.getCategory());
        assertThat(dto.getUrl()).isEqualTo(ca.getUrl());
        assertThat(dto.getTitle()).isEqualTo(ca.getTitle());
        assertThat(dto.getPeriod()).isEqualTo(ca.getPeriod());
        assertThat(dto.getViewCount()).isEqualTo(ca.getViewCount());

        // verify
        verify(caService, times(1)).findById(id);
    }

    @Test
    @DisplayName("CAController : 성공적으로 CA 를 지웠을 때 id 반환")
    void deleteById() throws Exception {
        // given
        long id = 123456L;

        doReturn(id).when(caService).deleteById(id);

        // when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/article/naver/{id}", id))
                .andExpect(status().isOk())
                .andReturn();

        Long removeId = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Long.class);

        // then
        assertThat(removeId).isEqualTo(id);

        // verify
        verify(caService, times(1)).deleteById(id);
    }
}