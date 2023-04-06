package com.sanhak.backend.domain.RO.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sanhak.backend.domain.RO.dto.response.ROResponse;
import com.sanhak.backend.domain.RO.dto.response.ROStatisticsResponse;
import com.sanhak.backend.domain.RO.entity.RepairOrder;
import com.sanhak.backend.domain.RO.service.ROService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ROController.class)
public class ROControllerTest {
    @Autowired private MockMvc mvc;

    @MockBean private ROService roService;

    @Test
    public void getAllROs() throws Exception{
        //given
        given(this.roService.getAllROs())
                .willReturn(createROResponses());
        //then
        this.mvc.perform(get("/api/ROs/all"))
                .andExpect(status().isOk());
        verify(roService, times(1)).getAllROs();
    }

    private List<ROResponse> createROResponses() {
        List<ROResponse> roResponses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            roResponses.add(new ROResponse(createRepairOrder(i)));
        }
        return roResponses;
    }

    private RepairOrder createRepairOrder(int idx) {
        return RepairOrder.builder().
                vehicleType("dummy"+idx).
                partNumber("dummy"+idx).
                causePart("dummy"+idx).
                causePartNameKor("dummy"+idx).
                causePartNameEng("dummy"+idx).
                bigPhenom("dummy"+idx).
                subPhenom("dummy"+idx).
                specialNote("dummy"+idx).
                location("dummy"+idx).
                causePartCluster("dummy"+idx).
                problematic("dummy"+idx).
                cause("dummy"+idx).build();
    }

    @Test
    public void getROStatistics() throws Exception{
        //given
        given(this.roService.getROStatistics())
                .willReturn(new ROStatisticsResponse(List.of(),List.of(),List.of()));
        //then
        this.mvc.perform(get("/api/ROs/statistics"))
                .andExpect(status().isOk());
        verify(roService, times(1)).getROStatistics();
    }

}
