package com.sanhak.backend.domain.RO.service;

import com.sanhak.backend.domain.RO.RepairOrder;
import com.sanhak.backend.domain.RO.repository.RORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ROService {
    private final RORepository roRepository;

    public RepairOrder findById(Long id) {
        return roRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Long deleteById(Long id) {
        roRepository.deleteById(id);
        return id;
    }
}
