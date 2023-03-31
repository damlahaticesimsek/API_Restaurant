package com.restaurant.api.entity;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * The persistent class for the category database table.
 *
 */
@Entity
@Table(name="category", schema="public")
@NamedQuery(name="Category.findAll", query="SELECT b FROM Category b")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Category_Id_seq_gen")
    @SequenceGenerator(name = "Category_Id_seq_gen", sequenceName = "Category_Id_seq", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
