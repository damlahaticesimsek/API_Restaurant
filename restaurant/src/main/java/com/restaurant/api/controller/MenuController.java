package com.restaurant.api.controller;

import com.restaurant.api.dto.*;
import com.restaurant.api.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private static Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/{tableNumber}/getMenu", method = RequestMethod.GET)
    public ResponseEntity<?> getMenu(@PathVariable Integer tableNumber) {

        List<GetMenuResponseDTO> serial = null;
        try {
            serial = menuService.getMenu();
        } catch (Exception e) {
            String errorMessage = "System error occured. Ref#" + UUID.randomUUID().toString();
            logger.error(errorMessage, e);
            return ResponseEntity.internalServerError().body(new ResponseWrapperBase<>(errorMessage, false));
        }
        return ResponseEntity.ok(new ResponseWrapper<>(serial));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/{tableNumber}/getMenuByCategory/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMenuByCategory(@PathVariable Integer tableNumber, @PathVariable Integer categoryId) {

        List<GetMenuResponseDTO> serial = null;
        try {
            serial = menuService.getMenuByCategory(categoryId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().body(new ResponseWrapperBase<>(e.getMessage(), false));
        }
        return ResponseEntity.ok(new ResponseWrapper<>(serial));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/{tableNumber}/getCategories", method = RequestMethod.GET)
    public ResponseEntity<?> getCategories(@PathVariable Integer tableNumber) {

        List<GetCategoriesResponseDTO> serial = null;
        try {
            serial = menuService.getCategories();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().body(new ResponseWrapperBase<>(e.getMessage(), false));
        }
        return ResponseEntity.ok(new ResponseWrapper<>(serial));
    }

}
