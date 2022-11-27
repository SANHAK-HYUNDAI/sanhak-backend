package com.sanhak.backend.domain.RO.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "repair_order")
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
}
