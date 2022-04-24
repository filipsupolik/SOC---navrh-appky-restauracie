package com.appslab.restaurantapp.restaurant;


import com.appslab.restaurantapp.food.Food;
import com.appslab.restaurantapp.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;
import java.security.Principal;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Restaurant {

    enum Region {
        BRATISLAVSKY,
        TRNAVSKY,
        TRENČIANSKY,
        NITRIANSKY,
        ZILINSKY,
        BANSKOBYSTRICKY,
        PRESOVSKY,
        KOSICKY
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String restaurantName;
    private String description;
    private DayOfWeek openingDay;
    private DayOfWeek closingDay;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String address;
    private Region region;



    @OneToMany(mappedBy="restaurant")
    private Set<Food> food;

    @ManyToOne
    @JoinColumn(name="adminId", nullable=false, insertable = false, updatable = false)
    private User adminUser;

    @Column(name = "adminId")
    private long adminId;

    public Restaurant() {
    }

    public Restaurant(long id, String restaurantName, String description, DayOfWeek openingDay, DayOfWeek closingDay, LocalTime openingTime, LocalTime closingTime, String address, Region region) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.description = description;
        this.openingDay = openingDay;
        this.closingDay = closingDay;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.address = address;
        this.region = region;
    }

    public Restaurant(String restaurantName, String description, DayOfWeek openingDay, DayOfWeek closingDay, LocalTime openingTime, LocalTime closingTime, String address, long adminId, Region region) {
        this.restaurantName = restaurantName;
        this.description = description;
        this.openingDay = openingDay;
        this.closingDay = closingDay;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.address = address;
        this.adminId = adminId;
        this.region = region;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DayOfWeek getOpeningDay() {
        return openingDay;
    }

    public void setOpeningDay(DayOfWeek openingDay) {
        this.openingDay = openingDay;
    }

    public DayOfWeek getClosingDay() {
        return closingDay;
    }

    public void setClosingDay(DayOfWeek closingDay) {
        this.closingDay = closingDay;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
