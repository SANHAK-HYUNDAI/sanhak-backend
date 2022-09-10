package com.sanhak.backend.domain.article.repository;

import com.sanhak.backend.domain.article.CafeArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CARepository extends JpaRepository<CafeArticle, Long> {
    Optional<CafeArticle> findById(Long id);

    void deleteById(Long id);
}
