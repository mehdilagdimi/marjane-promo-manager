package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import jakarta.persistence.*;

@Entity
public class ExemptedFromPromotion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    private SubCategory subCategory;

}
