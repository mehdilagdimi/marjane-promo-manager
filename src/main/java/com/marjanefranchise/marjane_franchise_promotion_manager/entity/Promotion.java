package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


@Entity
public class Promotion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private float percentage;


    @Column(nullable = false)
    private Timestamp validUntil;

    @Column(nullable = false)
    private String status = "en cours";

    @Column()
    private String comment;
    @Column(nullable = false)
    private Timestamp created_at = Timestamp.from(Instant.now());


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "subcategory_promotion",
            joinColumns = @JoinColumn(name = "subcategory_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "promotion_id", referencedColumnName = "id")
    )
    List<Category> subCategoryList;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Timestamp getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Timestamp validUntil) {
        this.validUntil = validUntil;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Promotion addSubCategory(Category subCategory){
        subCategoryList.add(subCategory);
        subCategory.addPromotion(this);
        return this;
    }
    public Promotion removeSubCategory(Category subCategory){
        subCategoryList.remove(subCategory);
        subCategory.removePromotion(this);
        return this;
    }
}
