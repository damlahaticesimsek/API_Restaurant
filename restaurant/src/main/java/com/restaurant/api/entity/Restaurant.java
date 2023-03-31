package com.restaurant.api.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Set;

/**
 * The persistent class for the restaurant database table.
 *
 */
@Entity
@Table(name="restaurant", schema="public")
@NamedQuery(name="Restaurant.findAll", query="SELECT b FROM Restaurant b")
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Restaurant_Id_seq_gen")
    @SequenceGenerator(name = "Restaurant_Id_seq_gen", sequenceName = "Restaurant_Id_seq", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "restaurant_name", length = 100)
    private String restaurantName;

    @Column(name = "restaurant_mail", length = 100)
    private String restaurantMail;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "res_id", insertable = false, updatable = false)
    private Set<RestaurantTable> restaurantTables;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantMail() {
        return restaurantMail;
    }

    public void setRestaurantMail(String restaurantMail) {
        this.restaurantMail = restaurantMail;
    }
}
