package com.sanhak.backend.domain.article.service;

import com.sanhak.backend.domain.article.CafeArticle;
import com.sanhak.backend.domain.article.dto.CAResDTO;
import com.sanhak.backend.domain.article.repository.CARepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CAService {
    private final CARepository CARepository;
    private final ModelMapper modelMapper;

    public CAResDTO findById(Long id) {
        CafeArticle ca = CARepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(ca, CAResDTO.class);
    }

    @Transactional
    public Long deleteById(Long id) {
        CARepository.deleteById(id);
        return id;
    }
}
