package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity @Table(name = "category")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    List<SubCategory> subCategories;


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
}
