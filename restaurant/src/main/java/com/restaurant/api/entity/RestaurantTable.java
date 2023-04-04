package com.restaurant.api.entity;


import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Set;

/**
 * The persistent class for the restaurant_table database table.
 *
 */

@Entity
@Table(name="restaurant_table", schema="public")
@NamedQuery(name="RestaurantTable.findAll", query="SELECT b FROM RestaurantTable b")
public class RestaurantTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RestaurantTable_Id_seq_gen")
    @SequenceGenerator(name = "RestaurantTable_Id_seq_gen", sequenceName = "RestaurantTable_Id_seq", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "res_id")
    private Long resId;

    @Column(name = "table_number")
    private Integer tableNumber;

    @Column(name = "table_active")
    private Boolean tableActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "res_id", insertable = false, updatable = false)
    private Restaurant restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Boolean getTableActive() {
        return tableActive;
    }

    public void setTableActive(Boolean tableActive) {
        this.tableActive = tableActive;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
