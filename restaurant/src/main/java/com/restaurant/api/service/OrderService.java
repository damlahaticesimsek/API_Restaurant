package com.restaurant.api.service;

import com.restaurant.api.dto.AddOrderRequestDTO;
import com.restaurant.api.dto.AddOrderResponseDTO;
import com.restaurant.api.dto.OrderItemDetailsResponseDTO;
import com.restaurant.api.entity.Order;
import com.restaurant.api.entity.OrderItem;
import com.restaurant.api.entity.RestaurantTable;
import com.restaurant.api.repository.OrderItemRepository;
import com.restaurant.api.repository.OrderRepository;
import com.restaurant.api.repository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private RestaurantTableRepository restaurantTableRepository;
    public AddOrderResponseDTO addOrder(Integer tableNumber, List<AddOrderRequestDTO> requestDTO) {
        List<OrderItemDetailsResponseDTO> responseDTOS1 = new ArrayList<>();

        RestaurantTable restaurantTable = restaurantTableRepository.findOneByTableNumber(tableNumber);
        restaurantTable.setTableActive(true);
        restaurantTableRepository.save(restaurantTable);

        Order order = new Order();
        order.setCreateDate(LocalDateTime.now());
        order.setTableId(restaurantTable.getId());
        order.setRestaurantTable(restaurantTable);

        List<Double> prices = requestDTO.stream().flatMap(x->x.getUnitPrice().describeConstable().stream()).collect(Collectors.toList());
        Double totalPrice = prices.stream().mapToDouble(Double::doubleValue).sum();
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);

        for (AddOrderRequestDTO orderDTO : requestDTO){
            OrderItemDetailsResponseDTO response = new OrderItemDetailsResponseDTO();
            response.setFoodId(orderDTO.getFoodId());
            response.setQuantity(orderDTO.getQuantity());
            response.setUnitPrice(orderDTO.getUnitPrice());
            responseDTOS1.add(response);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setOrder(order);
            orderItem.setFoodId(orderDTO.getFoodId());
            orderItem.setQuantity(orderDTO.getQuantity());
            orderItem.setUnitPrice(orderDTO.getUnitPrice());
            orderItemRepository.save(orderItem);
        }

        AddOrderResponseDTO responseDTO = new AddOrderResponseDTO();
        responseDTO.setOrderId(order.getId());
        responseDTO.setTotalPrice(totalPrice);
        responseDTO.setOrderItemDetailsResponseDTOS(responseDTOS1);

        return responseDTO;
    }
}
