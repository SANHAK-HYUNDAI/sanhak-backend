package com.sanhak.backend.domain.RO.controller;

import com.sanhak.backend.domain.RO.RepairOrder;
import com.sanhak.backend.domain.RO.dto.ROResDTO;
import com.sanhak.backend.domain.RO.service.ROService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ro")
public class ROController {
    private final ROService repairOrderService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ROResDTO> findById(@PathVariable(name = "id") Long id) {
        RepairOrder repairOrder = repairOrderService.findById(id);
        ROResDTO roResDTO = modelMapper.map(repairOrder, ROResDTO.class);
        return ResponseEntity.ok(roResDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(repairOrderService.deleteById(id));
    }
}
