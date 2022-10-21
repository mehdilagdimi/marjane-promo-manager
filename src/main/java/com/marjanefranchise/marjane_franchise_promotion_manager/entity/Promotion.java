package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;


@Entity
public class Promotion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private float percentage;
    @Column(nullable = false)

    private Timestamp validUntil;
    @Column(nullable = false)

    private Timestamp created_at = Timestamp.from(Instant.now());

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
}
