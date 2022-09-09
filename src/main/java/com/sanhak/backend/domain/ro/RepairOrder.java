package com.sanhak.backend.domain.ro;

import com.sanhak.backend.global.TimeExtend;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity(name = "repair_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RepairOrder extends TimeExtend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ro_id")
    private Long id;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "part_number")
    private String partNumber;

    @Column(name = "cause_part")
    private String causePart;

    @Column(name = "cause_part_name")
    private String causePartName;

    @Column(name = "symptom")
    private String symptom;

    @Column(name = "special_note")
    private String specialNote;

    @Column(name = "location")
    private String location;

    @Column(name = "cause_part_cluster")
    private String causePartCluster;

    @Column(name = "problematic_situation")
    private String problematicSituation;

    @Column(name = "cause")
    private String cause;

    @Column(name = "doc_created_at")
    private LocalDateTime docCreatedAt;

    @Builder
    public RepairOrder(Long id, String vehicleType, String partNumber, String causePart, String causePartName, String symptom, String specialNote, String location, String causePartCluster, String problematicSituation, String cause, LocalDateTime docCreatedAt) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.partNumber = partNumber;
        this.causePart = causePart;
        this.causePartName = causePartName;
        this.symptom = symptom;
        this.specialNote = specialNote;
        this.location = location;
        this.causePartCluster = causePartCluster;
        this.problematicSituation = problematicSituation;
        this.cause = cause;
        this.docCreatedAt = docCreatedAt;
    }
}
