package com.sanhak.backend.domain.RO.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "repair_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RepairOrder {
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
    @Column(name = "big_phenom")
    private String bigPhenom;
    @Column(name = "sub_phenom")
    private String subPhenom;
    @Column(name = "special_note")
    private String specialNote;
    @Column(name = "location")
    private String location;
    @Column(name = "cause_part_cluster")
    private String causePartCluster;
    @Column(name = "problematic")
    private String problematic;
    @Column(name = "cause")
    private String cause;

    @Builder
    public RepairOrder(Long id, String vehicleType, String partNumber, String causePart, String causePartNameKor,
                       String causePartNameEng, String bigPhenom, String subPhenom, String specialNote,
                       String location, String causePartCluster, String problematic, String cause) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.partNumber = partNumber;
        this.causePart = causePart;
        this.causePartNameKor = causePartNameKor;
        this.causePartNameEng = causePartNameEng;
        this.bigPhenom = bigPhenom;
        this.subPhenom = subPhenom;
        this.specialNote = specialNote;
        this.location = location;
        this.causePartCluster = causePartCluster;
        this.problematic = problematic;
        this.cause = cause;
    }
}
