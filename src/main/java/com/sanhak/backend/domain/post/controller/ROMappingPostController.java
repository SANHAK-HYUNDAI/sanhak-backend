package com.sanhak.backend.domain.post.controller;

import com.sanhak.backend.domain.post.ROMappingPost;
import com.sanhak.backend.domain.post.dto.PostCrtDTO;
import com.sanhak.backend.domain.post.dto.PostResDTO;
import com.sanhak.backend.domain.post.service.ROMappingPostService;
import com.sanhak.backend.global.PageResDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class ROMappingPostController {
    private final ROMappingPostService roMappingPostService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<PageResDTO> findByPostSearchWithPagination() {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<PostResDTO> create(@RequestBody PostCrtDTO dto) {
        ROMappingPost roMappingPost = roMappingPostService.create(dto);
        PostResDTO postResDTO = modelMapper.map(roMappingPost, PostResDTO.class);
        return ResponseEntity.ok(postResDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(roMappingPostService.deleteById(id));
    }
}
