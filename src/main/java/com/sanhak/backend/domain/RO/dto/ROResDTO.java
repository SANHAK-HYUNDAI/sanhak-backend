package com.sanhak.backend.domain.RO.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ROResDTO {
    private Long id;
    private String vehicleType;
    private String partNumber;
    private String causePart;
    private String causePartName;
    private String symptom;
    private String specialNote;
    private String location;
    private String causePartCluster;
    private String problematicSituation;
    private String cause;
    private LocalDateTime docCreatedAt;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
