package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExemptedFromPromotion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
