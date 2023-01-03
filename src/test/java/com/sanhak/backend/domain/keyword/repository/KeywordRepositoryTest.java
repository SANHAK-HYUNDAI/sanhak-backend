package com.sanhak.backend.domain.keyword.repository;

import static org.assertj.core.api.Assertions.*;

import com.sanhak.backend.domain.keyword.entity.CAKeyword;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
class KeywordRepositoryTest {

    @Autowired
    CAKeywordRepository keywordRepository;

    @BeforeAll
    public void init() {
        IntStream.rangeClosed(1,80)
                .forEach(idx ->{
                    CAKeyword CAKeyword = new CAKeyword("word" + idx, idx);
                    keywordRepository.save(CAKeyword);
                });
    }

    @Test
    public void findTop50ByOrderByFrequencyDescTest() throws Exception{
        //given
        int firstIndex=0;
        int lastIndex=0;
        //when
        List<CAKeyword> result = keywordRepository.findTop50ByOrderByFrequencyDesc();
        lastIndex=result.size()-1;
        //then
        assertThat(result.size()).isEqualTo(50);
        assertThat(result.get(firstIndex).getFrequency()).isEqualTo(80);
        assertThat(result.get(lastIndex).getFrequency()).isEqualTo(31);
    }
}