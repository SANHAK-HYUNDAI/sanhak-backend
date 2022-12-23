package com.sanhak.backend.domain.CA.repository;

import com.sanhak.backend.domain.CA.entity.CafeArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CARepository extends JpaRepository<CafeArticle,Long> {
}
