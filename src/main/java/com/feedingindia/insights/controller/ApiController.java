package com.feedingindia.insights.controller;

import com.feedingindia.insights.dtos.TransactionDTO;
import com.feedingindia.insights.exception.CustomException;
import com.feedingindia.insights.exception.CustomExceptionHandler;
import com.feedingindia.insights.models.Category;
import com.feedingindia.insights.service.CategoryService;
import com.feedingindia.insights.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ApiController {

    private final TransactionService transactionService;
    private final CategoryService categoryService;

    public ApiController(CategoryService categoryService, TransactionService transactionService) {
        this.categoryService = categoryService;
        this.transactionService = transactionService;
    }
    @GetMapping("/get-categories-list")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categoryList;
        try{
            categoryList = categoryService.getAllCategories();
        }catch (CustomException e){
            throw new CustomExceptionHandler.InsightsWrappedException(e);
        }catch (Exception e){
            throw new CustomExceptionHandler.WrappedException(e);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/record-transaction")
    public ResponseEntity<String> recordTransaction(@RequestBody TransactionDTO transactionDTO){
        try{
            transactionService.recordTransaction(transactionDTO);
        }catch (CustomException e){
            throw new CustomExceptionHandler.InsightsWrappedException(e);
        }catch (Exception e){
            throw new CustomExceptionHandler.WrappedException(e);
        }
        return new ResponseEntity<>("Successfully Saved", HttpStatus.OK);
    }

}
