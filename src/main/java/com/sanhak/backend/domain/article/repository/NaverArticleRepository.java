package com.sanhak.backend.domain.article.repository;

import com.sanhak.backend.domain.article.NaverArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NaverArticleRepository extends JpaRepository<NaverArticle, Long> {
    Optional<NaverArticle> findById(Long id);

    void deleteById(Long id);
}
