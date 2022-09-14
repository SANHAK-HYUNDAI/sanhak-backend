package com.sanhak.backend.domain.article.repository;

import com.sanhak.backend.domain.article.CafeArticle;
import com.sanhak.backend.global.config.QueryDSLConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@Import(QueryDSLConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CARepositoryTest {

    @Autowired
    private CARepository caRepository;

    @BeforeAll
    private void init() {
        IntStream.range(0, 5).forEach(i -> {
            CafeArticle ca = CafeArticle.builder()
                    .id((long) i)
                    .cafeName("cafe name" + i)
                    .broadName("broad name" + i)
                    .userName("user name" + i)
                    .category("category" + i)
                    .content("content" + i)
                    .period(1)
                    .title("title" + i)
                    .url("url" + i)
                    .viewCount(0L)
                    .docCreatedAt(LocalDateTime.now())
                    .isMailing(false)
                    .build();
            caRepository.save(ca);
        });
    }

    @Test
    @DisplayName("CARepository : findById가 정상 작동하여 저장된 객체를 반환하는지 확인")
    void findById() {
        // given
        CafeArticle ca = CafeArticle.builder()
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
        long cnt = caRepository.count();
        // when
        CafeArticle savedCA = caRepository.save(ca);

        // then
        assertThat(savedCA.getId()).isGreaterThanOrEqualTo(0L);
        assertThat(caRepository.count()).isEqualTo(cnt + 1);
    }

    @Test
    @DisplayName("CARepository : 기존에 있던 객체를 잘 삭제하는지 확인")
    void deleteById() {
        // given
        long id = 1;
        long cnt = caRepository.count();

        // when
        caRepository.deleteById(id);
        caRepository.flush();
        Optional<CafeArticle> optCA = caRepository.findById(id);

        // then
        assertThat(optCA.isPresent()).isEqualTo(false);
        assertThat(caRepository.count()).isEqualTo(cnt - 1);
    }
}