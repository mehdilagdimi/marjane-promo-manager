package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import jakarta.persistence.*;

@Entity
public class SubCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float price;

    @ManyToOne
    @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    ExemptedFromPromotion exemptedFromPromotion;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
