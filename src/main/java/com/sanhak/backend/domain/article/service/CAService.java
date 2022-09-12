package com.sanhak.backend.domain.article.service;

import com.sanhak.backend.domain.article.CafeArticle;
import com.sanhak.backend.domain.article.repository.CARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CAService {
    private final CARepository CARepository;

    public CafeArticle findById(Long id) {
        return CARepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Long deleteById(Long id) {
        CARepository.deleteById(id);
        return id;
    }
}
