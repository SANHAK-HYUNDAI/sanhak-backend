package com.sanhak.backend.domain.RO.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.sanhak.backend.domain.RO.dto.response.ROResponse;
import com.sanhak.backend.domain.RO.dto.response.ROStatisticsResponse;
import com.sanhak.backend.domain.RO.entity.RepairOrder;
import com.sanhak.backend.domain.RO.repository.RORepository;
import com.sanhak.backend.domain.category.service.ROCategoryService;
import com.sanhak.backend.domain.keyword.service.ROKeywordService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ROServiceTest {

    @Mock
    private ROKeywordService keywordService;
    @Mock
    private ROCategoryService roCategoryService;
    @Mock
    private RORepository roRepository;

    @InjectMocks
    private ROService roService;

    @Test
    public void getAllROs() throws Exception {
        //given
        List<RepairOrder> ros = createRos();
        given(roRepository.findAll())
                .willReturn(ros);
        //when
        List<ROResponse> result = roService.getAllROs();
        List<ROResponse> answer = ros.stream()
                .map(ro -> new ROResponse(ro))
                .collect(Collectors.toUnmodifiableList());
        //then
        verify(roRepository, times(1)).findAll();
        assertThat(result.size()).isEqualTo(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            assertThat(result.get(i).getVehicleType()).isEqualTo(answer.get(i).getVehicleType());
            assertThat(result.get(i).getCausePartNameKor()).isEqualTo(answer.get(i).getCausePartNameKor());
            assertThat(result.get(i).getBigPhenom()).isEqualTo(answer.get(i).getBigPhenom());
            assertThat(result.get(i).getSubPhenom()).isEqualTo(answer.get(i).getSubPhenom());
            assertThat(result.get(i).getSpecialNote()).isEqualTo(answer.get(i).getSpecialNote());
            assertThat(result.get(i).getLocation()).isEqualTo(answer.get(i).getLocation());
            assertThat(result.get(i).getProblematic()).isEqualTo(answer.get(i).getProblematic());
            assertThat(result.get(i).getCause()).isEqualTo(answer.get(i).getCause());
        }
    }

    private List<RepairOrder> createRos() {
        List<RepairOrder> ros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ros.add(RepairOrder.builder().
                    vehicleType("dummy").
                    partNumber("dummy").
                    causePart("dummy").
                    causePartNameKor("dummy").
                    causePartNameEng("dummy").
                    bigPhenom("dummy").
                    subPhenom("dummy").
                    specialNote("dummy").
                    location("dummy").
                    causePartCluster("dummy").
                    problematic("dummy").
                    cause("dummy").build());
        }
        return ros;
    }

    @Test
    public void getROStatistics() throws Exception {
        //given
        given(keywordService.getTop50Keywords()).willReturn(List.of());
        given(roCategoryService.getAllBigCategories()).willReturn(List.of());
        given(roCategoryService.getAllSubCategories()).willReturn(List.of());
        //when
        ROStatisticsResponse roStatistics = roService.getROStatistics();
        //then
        verify(keywordService, times(1)).getTop50Keywords();
        verify(roCategoryService, times(1)).getAllBigCategories();
        verify(roCategoryService, times(1)).getAllSubCategories();
    }

    @Test
    public void getRepairOrdersByCafeArticleId() throws Exception {
        //given
        List<RepairOrder> ros = createRos();
        given(roRepository.findRepairOrdersByCafeArticleId(anyLong()))
                .willReturn(ros);
        long caId = 1L;
        //when
        List<ROResponse> responses = roService.getRepairOrdersByCafeArticleId(caId);
        List<ROResponse> answer = ros.stream()
                .map(ro -> new ROResponse(ro))
                .collect(Collectors.toUnmodifiableList());
        //then
        verify(roRepository, times(1)).findRepairOrdersByCafeArticleId(caId);
        for (int i = 0; i < answer.size(); i++) {
            assertThat(answer.get(i).getVehicleType()).isEqualTo(responses.get(i).getVehicleType());
            assertThat(answer.get(i).getCausePartNameKor()).isEqualTo(responses.get(i).getCausePartNameKor());
            assertThat(answer.get(i).getBigPhenom()).isEqualTo(responses.get(i).getBigPhenom());
            assertThat(answer.get(i).getSubPhenom()).isEqualTo(responses.get(i).getSubPhenom());
            assertThat(answer.get(i).getSpecialNote()).isEqualTo(responses.get(i).getSpecialNote());
            assertThat(answer.get(i).getLocation()).isEqualTo(responses.get(i).getLocation());
            assertThat(answer.get(i).getProblematic()).isEqualTo(responses.get(i).getProblematic());
            assertThat(answer.get(i).getCause()).isEqualTo(responses.get(i).getCause());
        }

    }
}
