package com.eCommerce.catalog.service;

import com.eCommerce.catalog.DTOS.CategoryDTO;
import com.eCommerce.catalog.model.Category;
import com.eCommerce.catalog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories) {
            categoryDTOS.add(new CategoryDTO(category.getCategoryName()));
        }
        return categoryDTOS;
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category savedCategory = categoryRepository.save(new Category(categoryDTO.categoryNameDTO()));

        return categoryDTO;
    }

    @Override
    public Optional<Category> getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
