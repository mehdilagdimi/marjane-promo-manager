package com.marjanefranchise.marjane_franchise_promotion_manager.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

public class Promotion {

    private int id;
    private float percentage;
    private Timestamp validUntil;
    private Timestamp created_at = Timestamp.from(Instant.now());

}
