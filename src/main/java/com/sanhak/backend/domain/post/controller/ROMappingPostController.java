package com.sanhak.backend.domain.post.controller;

import com.sanhak.backend.domain.post.dto.PostCrtDTO;
import com.sanhak.backend.domain.post.dto.PostDTO;
import com.sanhak.backend.domain.post.dto.PostResDTO;
import com.sanhak.backend.domain.post.dto.PostSearch;
import com.sanhak.backend.domain.post.service.ROMappingPostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class ROMappingPostController {
    private final ROMappingPostService roMappingPostService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<PostResDTO> findPostsWithPagination(@Validated PostSearch postSearch) {
        Page<PostDTO> roMappingPosts = roMappingPostService.searchPostWithPagination(postSearch);
        PostResDTO response = new PostResDTO(roMappingPosts);
        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<PostDTO> create(@RequestBody PostCrtDTO dto) {
        PostDTO postDTO = roMappingPostService.create(dto);
        return ResponseEntity.ok(postDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(roMappingPostService.deleteById(id));
    }
}
