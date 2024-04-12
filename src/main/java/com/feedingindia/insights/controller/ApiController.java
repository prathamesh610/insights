package com.feedingindia.insights.controller;

import com.feedingindia.insights.dtos.TransactionDTO;
import com.feedingindia.insights.models.Category;
import com.feedingindia.insights.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")

public class ApiController {

    private final CategoryService categoryService;

    public ApiController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/get-all-categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categoryList = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/record-transaction")
    public ResponseEntity<String> recordTransaction(@RequestBody TransactionDTO transactionDTO){


        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
