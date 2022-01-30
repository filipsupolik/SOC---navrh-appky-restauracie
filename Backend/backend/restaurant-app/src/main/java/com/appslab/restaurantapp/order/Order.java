package com.appslab.restaurantapp.order;

import com.appslab.restaurantapp.user.User;

import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
    boolean completed;


    @ManyToOne
    @JoinColumn(name="restaurantAdminId", nullable=false, insertable = false, updatable = false)
    private User adminUser;

    @Column(name = "restaurantAdminId")
    private long restaurantAdminId;




}
