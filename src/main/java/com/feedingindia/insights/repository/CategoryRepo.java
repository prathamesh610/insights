package com.feedingindia.insights.repository;

import com.feedingindia.insights.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

//    List<Category> findAll();
}
