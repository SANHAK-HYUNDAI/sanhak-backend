package com.sanhak.backend.domain.similarity.entity;

import com.sanhak.backend.domain.CA.entity.CafeArticle;
import com.sanhak.backend.domain.RO.entity.RepairOrder;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "similarity")
public class Similarity {
    @Id
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
}
