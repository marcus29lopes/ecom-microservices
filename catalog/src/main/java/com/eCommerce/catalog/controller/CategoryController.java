package com.eCommerce.catalog.controller;

import com.eCommerce.catalog.DTOS.CategoryDTO;
import com.eCommerce.catalog.model.Category;
import com.eCommerce.catalog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/eCommerce")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/category/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping(value = "/category")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.saveCategory(categoryDTO),HttpStatus.OK);
    }
}
