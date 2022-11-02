package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.getBeanSettersFI;
import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;


@Entity
public class Promotion implements getBeanSettersFI {

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
            joinColumns = @JoinColumn(name = "promotion_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    )
    List<Category> subCategoryList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="center_id", referencedColumnName = "id")
    Center center;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

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

    public List<Category> getSubCategoryList() {
        return subCategoryList;
    }

    public Promotion addSubCategory(Category subCategory){
        subCategoryList.add(subCategory);
        subCategory.addPromotion(this);
        return this;
    }
    public Promotion addSubCategory(List<Category> subCategories){
        for(Category subCategory : subCategories){
            subCategoryList.add(subCategory);
            subCategory.addPromotion(this);
        }
        return this;
    }
    public Promotion removeSubCategory(Category subCategory){
        subCategoryList.remove(subCategory);
        subCategory.removePromotion(this);
        return this;
    }

    @Override
    public Map<String, BeanSetterFI> getSetters(){
        Map<String, BeanSetterFI> beanSettersAsLambdasMap;

        BeanSetterFI<Float> beanSetPercentage = this::setPercentage;
        BeanSetterFI<Timestamp> beanSetValidUntil = this::setValidUntil;
        BeanSetterFI<List<Category>> beanSetSubCategory = this::addSubCategory;
        BeanSetterFI<Center> beanSetCenter = this::setCenter;

        beanSettersAsLambdasMap = new HashMap<>(Map.ofEntries(
                Map.entry("percentage", beanSetPercentage),
                Map.entry("validUntil", beanSetValidUntil),
                Map.entry("subcategories", beanSetSubCategory),
                Map.entry("center", beanSetCenter)
        ));
        return beanSettersAsLambdasMap;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", percentage=" + percentage +
                ", validUntil=" + validUntil +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
