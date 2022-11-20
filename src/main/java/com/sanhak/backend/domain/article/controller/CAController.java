package com.sanhak.backend.domain.article.controller;

import com.sanhak.backend.domain.article.dto.CAResDTO;
import com.sanhak.backend.domain.article.service.CAService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article/naver")
public class CAController {
    private final CAService caService;

    @GetMapping("/{id}")
    public ResponseEntity<CAResDTO> findById(@PathVariable(name = "id") Long id) {
        CAResDTO caResDTO = caService.findById(id);
        return ResponseEntity.ok(caResDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(caService.deleteById(id));
    }
}
