package com.sanhak.backend.domain.similarity.entity;

import com.sanhak.backend.domain.CA.entity.CafeArticle;
import com.sanhak.backend.domain.RO.entity.RepairOrder;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "similarity")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Similarity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "similarity_id")
    private Long id;

    @ManyToOne(targetEntity = CafeArticle.class)
    @JoinColumn(
            name = "ca_id",
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
    )
    private CafeArticle cafeArticle;

    @ManyToOne(targetEntity = RepairOrder.class)
    @JoinColumn(
            name = "ro_id",
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
    )
    private RepairOrder repairOrder;

    public Similarity(CafeArticle cafeArticle, RepairOrder repairOrder) {
        this.cafeArticle = cafeArticle;
        this.repairOrder = repairOrder;
    }
}
