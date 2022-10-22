package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.CategoryParent;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class SubCategory extends CategoryParent {


    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    Category category;

    @OneToMany(mappedBy = "subCategory", fetch = FetchType.LAZY)
    List<Promotion> promotion;

    @OneToMany(mappedBy = "subCategory")
    List<ExemptedFromPromotion> exemptedFromPromotion;

    public SubCategory(){
        
    }
    public SubCategory(Category category, List<Promotion> promotion, List<ExemptedFromPromotion> exemptedFromPromotion) {
        this.category = category;
        this.promotion = promotion;
        this.exemptedFromPromotion = exemptedFromPromotion;
    }

    public SubCategory(int id, String name, Category category, List<Promotion> promotion, List<ExemptedFromPromotion> exemptedFromPromotion) {
        super(id, name);
        this.category = category;
        this.promotion = promotion;
        this.exemptedFromPromotion = exemptedFromPromotion;
    }

    public SubCategory(String name, Category category, List<Promotion> promotion, List<ExemptedFromPromotion> exemptedFromPromotion) {
        super(name);
        this.category = category;
        this.promotion = promotion;
        this.exemptedFromPromotion = exemptedFromPromotion;
    }
}
