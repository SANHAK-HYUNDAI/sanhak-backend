package com.sanhak.backend.domain.comment.controller;

import com.sanhak.backend.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> removeById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(commentService.deleteById(id));
    }
}
