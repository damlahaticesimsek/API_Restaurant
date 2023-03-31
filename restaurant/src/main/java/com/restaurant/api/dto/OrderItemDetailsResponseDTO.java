package com.restaurant.api.dto;

import com.restaurant.api.entity.OrderItem;

public class OrderItemDetailsResponseDTO {
    private Long foodId;
    private Integer quantity;
    private Double unitPrice;

    public void importFrom(OrderItem orderItem){
        this.setFoodId(orderItem.getFoodId());
        this.setQuantity(orderItem.getQuantity());
        this.setUnitPrice(orderItem.getUnitPrice());
    }


    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
