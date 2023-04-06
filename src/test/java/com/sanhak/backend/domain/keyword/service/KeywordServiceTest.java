package com.sanhak.backend.domain.keyword.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.sanhak.backend.domain.keyword.dto.response.KeywordResponse;
import com.sanhak.backend.domain.keyword.entity.CAKeyword;
import com.sanhak.backend.domain.keyword.repository.CAKeywordRepository;
import com.sanhak.backend.domain.keyword.repository.ROKeywordRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class KeywordServiceTest {

    @Mock private CAKeywordRepository caKeywordRepository;
    @InjectMocks private CAKeywordService caKeywordService;

    @Test
    public void getTop50CAKeywords() throws Exception{
        //given
        List<CAKeyword> cas = createCAs();
        given(caKeywordRepository.findTop50ByOrderByFrequencyDesc())
                .willReturn(cas);
        //when
        List<KeywordResponse> result = caKeywordService.getTop50Keywords();
        //then
        verify(caKeywordRepository,times(1)).findTop50ByOrderByFrequencyDesc();
        for (int i = 1; i < result.size(); i++) {
            assertThat(result.get(i).getValue()).isLessThanOrEqualTo(result.get(i - 1).getValue());
        }
    }

    private List<CAKeyword> createCAs() {
        List<CAKeyword> cas = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            cas.add(new CAKeyword("keyword" + i, i));
        }
        cas.sort((a, b) -> b.getFrequency() - a.getFrequency());
        return cas;
    }
}
