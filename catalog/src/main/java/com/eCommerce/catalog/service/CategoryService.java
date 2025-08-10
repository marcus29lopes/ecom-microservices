package com.eCommerce.catalog.service;

import com.eCommerce.catalog.DTOS.CategoryDTO;
import com.eCommerce.catalog.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO saveCategory(CategoryDTO categoryDTO);

   Optional<Category> getCategoryById(Long id);
}
