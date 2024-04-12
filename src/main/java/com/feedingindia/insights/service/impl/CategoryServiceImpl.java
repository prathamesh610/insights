package com.feedingindia.insights.service.impl;

import com.feedingindia.insights.exception.CustomException;
import com.feedingindia.insights.exception.ErrorCode;
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
    public List<Category> getAllCategories() throws CustomException {
        List<Category> categoryList = categoryRepo.findAll();

        if(categoryList.isEmpty()) throw new CustomException(ErrorCode.EMPTY_CATEGORIES, ErrorCode.EMPTY_CATEGORIES.getMessage());
        return categoryList;
    }

}
