package com.sanhak.backend.domain.RO.controller;

import com.sanhak.backend.domain.RO.dto.request.ROPageRequest;
import com.sanhak.backend.domain.RO.dto.response.ROPageResponse;
import com.sanhak.backend.domain.RO.service.ROService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ROs")
@RequiredArgsConstructor
public class ROController {

    private final ROService roService;

    @GetMapping
    public ResponseEntity<ROPageResponse> getROs(ROPageRequest roPageRequest) {
        ROPageResponse response = roService.getROs(roPageRequest);
        return ResponseEntity.ok(response);
    }
}
