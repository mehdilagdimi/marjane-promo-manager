package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.CategoryParent;
import jakarta.persistence.*;

import java.util.List;

@Entity @Table(name = "category")
public class Category extends CategoryParent {


    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    List<SubCategory> subCategories;


    @OneToOne(mappedBy = "category", fetch = FetchType.LAZY)
    SectionManager sectionManager;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    List<Promotion> promotion;


    public Category(){

    }
    public Category(List<SubCategory> subCategories, SectionManager sectionManager, List<Promotion> promotion) {
        this.subCategories = subCategories;
        this.sectionManager = sectionManager;
        this.promotion = promotion;
    }

    public Category(int id, String name, List<SubCategory> subCategories, SectionManager sectionManager, List<Promotion> promotion) {
        super(id, name);
        this.subCategories = subCategories;
        this.sectionManager = sectionManager;
        this.promotion = promotion;
    }

    public Category(String name, List<SubCategory> subCategories, SectionManager sectionManager, List<Promotion> promotion) {
        super(name);
        this.subCategories = subCategories;
        this.sectionManager = sectionManager;
        this.promotion = promotion;
    }
}
