package com.restaurant.api.controller;

import com.restaurant.api.dto.*;
import com.restaurant.api.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private OrderService orderService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/{tableNumber}/addOrder", method = RequestMethod.POST)
    public ResponseEntity<?> addOrder(@PathVariable Integer tableNumber, @RequestBody List<AddOrderRequestDTO> requestDTO) {

        AddOrderResponseDTO order = null;
        try {
            order = orderService.addOrder(tableNumber, requestDTO);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().body(new ResponseWrapperBase<>(e.getMessage(), false));
        }
        return ResponseEntity.ok(new ResponseWrapper<>(order));
    }
}
