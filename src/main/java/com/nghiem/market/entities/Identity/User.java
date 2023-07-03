package com.nghiem.market.entities.Identity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import com.nghiem.market.entities.BaseEntity;
import com.nghiem.market.entities.products.Vehicle;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String FullName;

    @Column
    private LocalDateTime DateOfBirth;

    @Column
    private String Address;

    @Column
    private GenderType Gender;

    @Column
    private String Email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Vehicle> sellingVehicles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public LocalDateTime getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public GenderType getGender() {
        return Gender;
    }

    public void setGender(GenderType gender) {
        Gender = gender;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Vehicle> getSellingVehicles() {
        return sellingVehicles;
    }

    public void setSellingVehicles(Set<Vehicle> sellingVehicles) {
        this.sellingVehicles = sellingVehicles;
    }
// constructors, getters, and setters

}