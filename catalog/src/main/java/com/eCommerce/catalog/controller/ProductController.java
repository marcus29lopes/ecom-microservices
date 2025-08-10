package com.eCommerce.catalog.controller;

import com.eCommerce.catalog.DTOS.ProductDTO;
import com.eCommerce.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/eCommerce")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product/save")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {

        return new ResponseEntity<>(productService.saveProduct(productDTO), HttpStatus.OK);
    }
}
