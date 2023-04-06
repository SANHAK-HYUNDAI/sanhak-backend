package com.sanhak.backend.domain.keyword.repository;

import static org.assertj.core.api.Assertions.*;

import com.sanhak.backend.domain.keyword.entity.CAKeyword;
import com.sanhak.backend.domain.keyword.entity.ROKeyword;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
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
    CAKeywordRepository caKeywordRepository;
    @Autowired
    ROKeywordRepository roKeywordRepository;
    private static List<CAKeyword> cas = new ArrayList<>();
    private static List<ROKeyword> ros = new ArrayList<>();

    @BeforeAll
    public void init() {
        for (int idx = 1; idx <= 80; idx++) {
            cas.add(new CAKeyword("caKeyword" + idx, idx));
            ros.add(new ROKeyword("roKeyword" + idx, idx));
        }
        caKeywordRepository.saveAll(cas);
        roKeywordRepository.saveAll(ros);
    }

    @Test
    public void findTop50CAKeyWordsByOrderByFrequencyDescTest() throws Exception{
        //given
        cas.sort((a,b)-> b.getFrequency() - a.getFrequency());
        int size = cas.size() > 50 ? 50 : cas.size();
        //when
        List<CAKeyword> result = caKeywordRepository.findTop50ByOrderByFrequencyDesc();
        //then
        assertThat(size).isEqualTo(result.size());
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i).getFrequency()).isEqualTo(cas.get(i).getFrequency());
        }
    }

    @Test
    public void findTop50ROKeywordsByOrderByFrequencyDescTest() throws Exception{
        //given
        ros.sort((a,b)-> b.getFrequency() - a.getFrequency());
        int size = ros.size() > 50 ? 50 : ros.size();
        //when
        List<ROKeyword> result = roKeywordRepository.findTop50ByOrderByFrequencyDesc();
        //then
        assertThat(size).isEqualTo(result.size());
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i).getFrequency()).isEqualTo(ros.get(i).getFrequency());
        }
    }
}