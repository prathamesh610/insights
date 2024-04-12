package com.feedingindia.insights.service.impl;

import com.feedingindia.insights.models.Category;
import com.feedingindia.insights.repository.CategoryRepo;
import com.feedingindia.insights.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;


    public CategoryServiceImpl(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }
    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList = categoryRepo.findAll();

        // TODO: Throw new Excpetion if categoriesList is empty
        return categoryList;
    }

}
