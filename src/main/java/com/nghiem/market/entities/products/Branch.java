package com.nghiem.market.entities.products;

import com.nghiem.market.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "branches")
@Getter
@Setter
public class Branch extends BaseEntity {

    @Column(nullable = false)
    public String name;

    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles;

    // constructors, getters, and setters

}