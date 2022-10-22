package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.Person;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class SectionManager extends Person {

    @OneToOne(mappedBy = "sectionManager", fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @MapsId
    Category category;


    public SectionManager() {
    }

    public SectionManager(int id, String fullname, String email, String passw) {
        super(id, fullname, email, passw);
    }

    public SectionManager(String fullname, String email, String passw) {
        super(fullname, email, passw);
    }
}
