package com.sanhak.backend.domain.post.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sanhak.backend.domain.RO.dto.ROResDTO;
import com.sanhak.backend.domain.article.dto.CAResDTO;
import com.sanhak.backend.domain.post.dto.PostCrtDTO;
import com.sanhak.backend.domain.post.dto.PostDTO;
import com.sanhak.backend.domain.post.dto.PostResDTO;
import com.sanhak.backend.domain.post.service.ROMappingPostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ROMappingPostControllerTest {

    @InjectMocks
    private ROMappingPostController roMappingPostController;

    @Mock
    private ROMappingPostService roMappingPostService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(roMappingPostController).build();
    }

    @Test
    @DisplayName("post list 반환")
    public void findPostsWithPaginationTest() throws Exception{
        PageRequest pageable = PageRequest.of(1, 10);
        List<PostDTO> lists = new ArrayList<>();
        LongStream.rangeClosed(1, 10)
                .forEach(i -> lists.add(PostDTO.builder().id(i).build()));

        PageImpl<PostDTO> result = new PageImpl<>(lists, pageable, 20);
        given(roMappingPostService.searchPostWithPagination(any())).willReturn(result);

        //when
        MvcResult mvcResult = mockMvc.perform(
                        get("/api/post"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //then
        PostResDTO postResDTO = new Gson().fromJson(mvcResult.getResponse().getContentAsString(), PostResDTO.class);
        assertThat(postResDTO).isEqualTo(new PostResDTO(result));
    }

    @Test
    @DisplayName("create 성공")
    public void createTest_success() throws Exception{
        //give
        PostCrtDTO crtDTO = PostCrtDTO.builder().naverArticleId(123L).repairOrderId(456L).build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(crtDTO);
        PostDTO postDTO = PostDTO.builder()
                .id(1L)
                .cafeArticle(CAResDTO.builder().id(123L).build())
                .repairOrder(ROResDTO.builder().id(456L).build())
                .build();
        given(roMappingPostService.create(crtDTO)).willReturn(postDTO);
        //when

        MvcResult mvcResult = mockMvc.perform(
                        post("/api/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andReturn();

        //then
        PostDTO returnedPostDTO = new Gson().fromJson(mvcResult.getResponse().getContentAsString(), PostDTO.class);
        assertThat(returnedPostDTO).isEqualTo(postDTO);
    }


    @Test
    public void deleteByIdTest() throws Exception{
        //give
        Long postId = 1L;
        given(roMappingPostService.deleteById(any())).willReturn(1L);
        //when
        MvcResult mvcResult = mockMvc.perform(
                        delete("/api/post/1"))
                .andExpect(status().isOk())
                .andReturn();

        //then
        assertThat(Long.parseLong(mvcResult.getResponse().getContentAsString())).isEqualTo(postId);
    }
}
