package com.sanhak.backend.domain.category.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.sanhak.backend.domain.category.entity.CABigCategory;
import com.sanhak.backend.domain.category.entity.CASubCategory;
import java.util.List;
import java.util.stream.LongStream;
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
class CASubCategoryRepositoryTest {

    @Autowired CABigCategoryRepository caBigCategoryRepository;
    @Autowired CASubCategoryRepository caSubCategoryRepository;

    @BeforeAll
    public void init() {
        LongStream.rangeClosed(1,10)
                .forEach(idx ->{
                    CABigCategory bigCategory = new CABigCategory("bigCate" + idx, idx);
                    caBigCategoryRepository.save(bigCategory);

                    for(long i=0; i<5; i++){
                        long subIdx = 5 * (idx - 1) + i+1;
                        CASubCategory caSubCategory = new CASubCategory("subCate" + subIdx, subIdx, bigCategory);
                        caSubCategoryRepository.save(caSubCategory);
                    }
                });
    }

    @Test
    public void findAllTest() throws Exception{
        //given
        long count =0;
        //when
        List<CASubCategory> result = caSubCategoryRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(50);
        for (CASubCategory caSubCategory : result) {
            assertThat(caSubCategory.getBigCategory().getCount()).isEqualTo(count/5 + 1);
            count++;
        }
    }

}