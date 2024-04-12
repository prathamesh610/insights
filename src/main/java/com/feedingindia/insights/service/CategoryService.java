package com.feedingindia.insights.service;

import com.feedingindia.insights.exception.CustomException;
import com.feedingindia.insights.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories() throws CustomException;
}
