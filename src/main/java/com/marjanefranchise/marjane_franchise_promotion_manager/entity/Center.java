package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Center {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;

    @OneToOne(mappedBy = "center", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    @PrimaryKeyJoinColumn
    Manager manager;

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<SectionManager> sectionManager = new ArrayList<>();

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Promotion> promotion = new ArrayList<>();

    public Manager getManager() {
        return manager;
    }

    public List<SectionManager> getSectionManager() {
        return sectionManager;
    }

    public void setSectionManager(List<SectionManager> sectionManager) {
        this.sectionManager = sectionManager;
    }

    public List<Promotion> getPromotion() {
        return promotion;
    }

    public void setPromotion(List<Promotion> promotion) {
        this.promotion = promotion;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Center center = (Center) o;

        return new EqualsBuilder().append(id, center.id).append(city, center.city).append(manager, center.manager).append(sectionManager, center.sectionManager).append(promotion, center.promotion).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(city).append(manager).append(sectionManager).append(promotion).toHashCode();
    }

    @Override
    public String toString() {
        return "Center{" +
                "id=" + id +
                ", city='" + city + '\'' +
//                ", manager=" + manager +
//                ", sectionManager=" + sectionManager +
//                ", promotion=" + promotion +
                '}';
    }
}
