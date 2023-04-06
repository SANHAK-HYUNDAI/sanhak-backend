package com.sanhak.backend.domain.CA.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sanhak.backend.domain.CA.dto.response.CADetailResponse;
import com.sanhak.backend.domain.CA.dto.response.CAStatisticsResponse;
import com.sanhak.backend.domain.CA.service.CAService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CAController.class)
public class CafeArticleControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CAService caService;

    @Test
    public void getAllCAsByBigPhenom() throws Exception {
        //given
        String bigPhenom = "bigPhenom";
        given(caService.getAllCAsByBigPhenom(bigPhenom))
                .willReturn(List.of());
        //then
        this.mvc.perform(get("/api/CAs/all")
                        .param(bigPhenom, bigPhenom))
                .andExpect(status().isOk());
        verify(caService, times(1)).getAllCAsByBigPhenom(bigPhenom);
    }

    @Test
    public void getCA() throws Exception {
        //given
        Long caId = 1L;
        CADetailResponse res = CADetailResponse.builder().build();
        given(caService.getDetailCAById(caId)).willReturn(res);
        //then
        this.mvc.perform(get("/api/CAs/" + caId))
                .andExpect(status().isOk());
        verify(caService, times(1)).getDetailCAById(caId);
    }

    @Test
    public void getCAStatistics() throws Exception {
        //given
        given(caService.getCAStatistics()).willReturn(new CAStatisticsResponse(List.of(), List.of(), List.of()));
        //then
        this.mvc.perform(get("/api/CAs/statistics"))
                .andExpect(status().isOk());
        verify(caService, times(1)).getCAStatistics();
    }
}
