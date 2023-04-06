package com.sanhak.backend.domain.CA.repository;

import com.sanhak.backend.domain.CA.entity.CafeArticle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CARepository extends JpaRepository<CafeArticle, Long> {
    @Query("select distinct ca from CafeArticle ca left join Similarity s on s.cafeArticle = ca left join RepairOrder ro on s.repairOrder=ro where ro.bigPhenom =:bigPhenom")
    public List<CafeArticle> findCafeArticlesByBigPhenom(String bigPhenom);
}
