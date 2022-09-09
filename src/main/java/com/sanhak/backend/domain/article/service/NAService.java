package com.sanhak.backend.domain.article.service;

import com.sanhak.backend.domain.article.NaverArticle;
import com.sanhak.backend.domain.article.repository.NARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NAService {
    private final NARepository naRepository;

    public NaverArticle findById(Long id) {
        return naRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Long deleteById(Long id) {
        naRepository.deleteById(id);
        return id;
    }
}
