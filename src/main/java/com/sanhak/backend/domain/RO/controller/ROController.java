package com.sanhak.backend.domain.RO.controller;

import com.sanhak.backend.domain.RO.dto.response.ROResponse;
import com.sanhak.backend.domain.RO.dto.response.ROStatisticsResponse;
import com.sanhak.backend.domain.RO.service.ROService;
import java.util.List;
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

    @GetMapping("/all")
    public ResponseEntity<List<ROResponse>> getAllROs() {
        List<ROResponse> result = roService.getAllROs();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/statistics")
    public ResponseEntity<ROStatisticsResponse> getROStatistics() {
        ROStatisticsResponse response = roService.getROStatistics();
        return ResponseEntity.ok(response);
    }
}
