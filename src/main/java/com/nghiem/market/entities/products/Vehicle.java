package com.nghiem.market.entities.products;

import com.nghiem.market.entities.BaseEntity;
import com.nghiem.market.entities.Identity.User;
import com.nghiem.market.entities.attachments.FileUpload;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "vehicles")
public class Vehicle extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String plateNumber;

    @Column(nullable = false)
    private LocalDate manufactureDate;

    @Column(nullable = false)
    private int mileage;

    @Column(nullable = false)
    private float engineCapacity;

    @Column(nullable = false)
    private String transmission;

    @Column(nullable = false)
    private String fuelType;

    @Column(nullable = false)
    private String bodyType;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String condition;

    @Column(nullable = false)
    private float price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_vehicle_id", nullable = false)
    private CategoryVehicle categoryVehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FileUpload> fileUploads;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User seller;
    // constructors, getters, and setters

}