package com.nghiem.market.entities.banners;

import com.nghiem.market.entities.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "banners")
public class Banner extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private String link;

    // constructors, getters, and setters
}