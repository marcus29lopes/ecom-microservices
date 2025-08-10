package com.eCommerce.catalog.service;

import com.eCommerce.catalog.DTOS.ProductDTO;
import com.eCommerce.catalog.model.Category;
import com.eCommerce.catalog.model.Product;
import com.eCommerce.catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {

        Category category = categoryService.getCategoryById(productDTO.categoryIdDTO())
                .orElseThrow(() ->new RuntimeException("Categoria nao encontrada"));

        Product product = new Product(productDTO.productNameDTO(), productDTO.productDescriptionDTO(), productDTO.productPriceDTO(), productDTO.productQuantityDTO(), category);
        productRepository.save(product);
        return productDTO;
    }
}
