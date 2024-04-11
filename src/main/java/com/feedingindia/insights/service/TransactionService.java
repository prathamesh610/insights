package com.feedingindia.insights.service;

import com.feedingindia.insights.dtos.TransactionDTO;
import com.feedingindia.insights.models.Category;

import java.util.List;

public interface TransactionService {
    List<Category> getAllCategories();

    void recordTransaction(TransactionDTO transactionDTO) throws Exception;
}
