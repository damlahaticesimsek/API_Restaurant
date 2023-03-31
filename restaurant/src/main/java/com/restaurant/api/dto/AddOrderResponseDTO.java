package com.restaurant.api.dto;

import java.util.List;

public class AddOrderResponseDTO {

    private Long orderId;
    private Double totalPrice;
    private List<OrderItemDetailsResponseDTO> orderItemDetailsResponseDTOS;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItemDetailsResponseDTO> getOrderItemDetailsResponseDTOS() {
        return orderItemDetailsResponseDTOS;
    }

    public void setOrderItemDetailsResponseDTOS(List<OrderItemDetailsResponseDTO> orderItemDetailsResponseDTOS) {
        this.orderItemDetailsResponseDTOS = orderItemDetailsResponseDTOS;
    }
}
