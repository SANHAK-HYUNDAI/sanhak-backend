package com.sanhak.backend.domain.article.service;

import com.sanhak.backend.domain.article.NaverArticle;
import com.sanhak.backend.domain.article.repository.NaverArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NaverArticleService {
    private final NaverArticleRepository naverArticleRepository;

    public NaverArticle findById(Long id) {
        return naverArticleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Long deleteById(Long id) {
        naverArticleRepository.deleteById(id);
        return id;
    }
}
