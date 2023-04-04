package com.restaurant.api.entity;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * The persistent class for the food database table.
 *
 */
@Entity
@Table(name="food", schema="public")
@NamedQuery(name="Food.findAll", query="SELECT b FROM Food b")
public class Food implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Food_Id_seq_gen")
    @SequenceGenerator(name = "Food_Id_seq_gen", sequenceName = "Food_Id_seq", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "price")
    private Double price;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
