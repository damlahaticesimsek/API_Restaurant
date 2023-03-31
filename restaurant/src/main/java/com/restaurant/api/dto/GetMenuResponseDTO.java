package com.restaurant.api.dto;

import com.restaurant.api.entity.Food;

public class GetMenuResponseDTO {

    private Long foodId;
    private String foodName;
    private Double price;
    private Long categoryId;

    public void importFrom(Food food){
        this.setFoodId(food.getId());
        this.setFoodName(food.getFoodName());
        this.setPrice(food.getPrice());
        this.setCategoryId(food.getCategoryId());
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
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
}
