package com.marjanefranchise.marjane_franchise_promotion_manager.base;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class CategoryParent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    public CategoryParent(){

    }
    public CategoryParent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryParent(String name) {
        this.name = name;
    }

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
