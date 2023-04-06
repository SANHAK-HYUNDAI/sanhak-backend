package com.sanhak.backend.domain.RO.repository;

import com.sanhak.backend.domain.CA.entity.CafeArticle;
import com.sanhak.backend.domain.RO.entity.RepairOrder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RORepository extends JpaRepository<RepairOrder, Long> {

    @Query("select ro from RepairOrder ro left join Similarity s on s.repairOrder=ro left join CafeArticle ca on s.cafeArticle =ca where ca.id=:caId")
    public List<RepairOrder> findRepairOrdersByCafeArticleId(Long caId);
}
