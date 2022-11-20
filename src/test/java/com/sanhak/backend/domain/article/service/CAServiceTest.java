package com.sanhak.backend.domain.article.service;

import com.sanhak.backend.domain.article.CafeArticle;
import com.sanhak.backend.domain.article.dto.CAResDTO;
import com.sanhak.backend.domain.article.repository.CARepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CAServiceTest {

    @Mock
    private CARepository caRepository;
    @InjectMocks
    private CAService caService;
    @Spy
    private ModelMapper modelMapper;

    @Test
    @DisplayName("CAService : 성공적으로 id를 찾을 수 있을 때 ca 값을 반환")
    void findById() {
        // given
        long id = 123456L;
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

        doReturn(Optional.of(ca)).when(caRepository).findById(id);

        // when
        CAResDTO dto = caService.findById(id);

        // then
        assertThat(dto.getId()).isEqualTo(ca.getId());
        assertThat(dto.getViewCount()).isEqualTo(ca.getViewCount());
        assertThat(dto.getPeriod()).isEqualTo(ca.getPeriod());
        assertThat(dto.getTitle()).isEqualTo(ca.getTitle());
        assertThat(dto.getUrl()).isEqualTo(ca.getUrl());
        assertThat(dto.getCategory()).isEqualTo(ca.getCategory());
        assertThat(dto.getContent()).isEqualTo(ca.getContent());
        assertThat(dto.getCafeName()).isEqualTo(ca.getCafeName());
        assertThat(dto.getBroadName()).isEqualTo(ca.getBroadName());

        // verify
        verify(caRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("CAService : 성공적으로 id를 찾을 수 없을 때 IllegalArgumentException 반환")
    void cantFindById() {
        // given
        long id = 123456L;
        doReturn(Optional.empty()).when(caRepository).findById(id);

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> caService.findById(id));

        // verify
        verify(caRepository, times(1)).findById(id);
    }

    @Test
    void deleteById() {
        // given
        long id = 123456L;

        // when
        Long removedId = caService.deleteById(id);

        // then
        assertThat(removedId).isEqualTo(id);

        // verify
        verify(caRepository, times(1)).deleteById(any());
    }
}