package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import jakarta.persistence.*;

@Entity
public class Center {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;

    @OneToOne
    @JoinColumn(name = "center_id", referencedColumnName = "id")
    Manager manager;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
