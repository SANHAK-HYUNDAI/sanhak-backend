package com.sanhak.backend.domain.post.controller;

import com.sanhak.backend.domain.post.ROMappingPost;
import com.sanhak.backend.domain.post.dto.PostCrtDTO;
import com.sanhak.backend.domain.post.dto.PostDTO;
import com.sanhak.backend.domain.post.dto.PostResponseDTO;
import com.sanhak.backend.domain.post.dto.PostSearch;
import com.sanhak.backend.domain.post.service.ROMappingPostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PostResponseDTO> findPostsWithPagination(@Validated PostSearch postSearch) {
        Page<PostDTO> roMappingPosts = roMappingPostService.searchPostWithPagination(postSearch);
        PostResponseDTO response = new PostResponseDTO(roMappingPosts);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PostDTO> create(@RequestBody PostCrtDTO dto) {
        ROMappingPost roMappingPost = roMappingPostService.create(dto);
        PostDTO postDTO = roMappingPost.toDTO();
        return ResponseEntity.ok(postDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(roMappingPostService.deleteById(id));
    }
}
