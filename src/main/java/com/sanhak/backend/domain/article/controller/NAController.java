package com.sanhak.backend.domain.article.controller;

import com.sanhak.backend.domain.article.NaverArticle;
import com.sanhak.backend.domain.article.dto.NAResDTO;
import com.sanhak.backend.domain.article.service.NAService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article/naver")
public class NAController {
    private final NAService naService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<NAResDTO> findById(@PathVariable(name = "id") Long id) {
        NaverArticle na = naService.findById(id);
        NAResDTO naResDTO = modelMapper.map(na, NAResDTO.class);
        return ResponseEntity.ok(naResDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(naService.deleteById(id));
    }
}
