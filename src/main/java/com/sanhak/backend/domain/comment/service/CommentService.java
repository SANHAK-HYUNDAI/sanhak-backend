package com.sanhak.backend.domain.comment.service;

import com.sanhak.backend.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Long deleteById(Long id) {
        commentRepository.removeById(id);
        return id;
    }
}
