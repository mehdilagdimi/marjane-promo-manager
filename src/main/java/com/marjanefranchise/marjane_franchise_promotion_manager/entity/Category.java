package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "category")
public class Category  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "category", fetch = FetchType.LAZY)
    private SectionManager sectionManager;

    @ManyToOne()
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Category> subCategories = new ArrayList<>();



    @ManyToMany(mappedBy = "subCategoryList", fetch = FetchType.LAZY)
    private List<Promotion> promotionList;


    public Category(){

    }

    public Category(int id, String name, Category parent, List<Category> subCategories, SectionManager sectionManager, List<Promotion> promotion) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.subCategories = subCategories;
        this.sectionManager = sectionManager;
        this.promotionList = promotionList;
    }

    public Category(String name, Category parent, List<Category> subCategories, SectionManager sectionManager, List<Promotion> promotionList) {
        this.name = name;
        this.parent = parent;
        this.subCategories = subCategories;
        this.sectionManager = sectionManager;
        this.promotionList = promotionList;
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

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public SectionManager getSectionManager() {
        return sectionManager;
    }

    public void setSectionManager(SectionManager sectionManager) {
        this.sectionManager = sectionManager;
    }

    public List<Promotion> getPromotion() {
        return promotionList;
    }

    public void setPromotion(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }

    public Category addSubCategory(Category subCategory){
        subCategories.add(subCategory);
        setParent(this);
        return this;
    }
    public Category removeSubCategory(Category subCategory){
        subCategories.remove(subCategory);

        return this;
    }

    public Category addPromotion(Promotion promotion){
        promotionList.add(promotion);
        return this;
    }

    public Category removePromotion(Promotion promotion){
        promotionList.remove(promotion);
        return this;
    }
}
