package com.sanhak.backend.domain.ro.controller;

import com.sanhak.backend.domain.ro.RepairOrder;
import com.sanhak.backend.domain.ro.dto.ROResDTO;
import com.sanhak.backend.domain.ro.service.RepairOrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ro")
public class RepairOrderController {
    private final RepairOrderService repairOrderService;
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
