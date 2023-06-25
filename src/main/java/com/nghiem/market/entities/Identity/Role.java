package com.nghiem.market.entities.Identity;

import com.nghiem.market.entities.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Column(nullable = false)
    private String name;

    // constructors, getters, and setters

}