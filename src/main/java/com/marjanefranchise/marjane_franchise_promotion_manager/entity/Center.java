package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Center {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;

    @OneToOne(mappedBy = "center", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
    Manager manager;

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<SectionManager> sectionManager;

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
