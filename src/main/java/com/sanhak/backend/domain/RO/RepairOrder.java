package com.sanhak.backend.domain.RO;

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

    @Column(name = "cause_part_name_kor")
    private String causePartNameKor;

    @Column(name = "cause_part_name_eng")
    private String causePartNameEng;

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


    @Builder
    public RepairOrder(Long id, String vehicleType, String partNumber, String causePart, String causePartNameKor, String causePartNameEng, String symptom, String specialNote, String location, String causePartCluster, String problematicSituation, String cause) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.partNumber = partNumber;
        this.causePart = causePart;
        this.causePartNameKor = causePartNameKor;
        this.causePartNameEng = causePartNameEng;
        this.symptom = symptom;
        this.specialNote = specialNote;
        this.location = location;
        this.causePartCluster = causePartCluster;
        this.problematicSituation = problematicSituation;
        this.cause = cause;
    }
}
