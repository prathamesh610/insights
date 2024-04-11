package com.feedingindia.insights.service.impl;

import com.feedingindia.insights.dtos.TransactionDTO;
import com.feedingindia.insights.models.Category;
import com.feedingindia.insights.models.Transaction;
import com.feedingindia.insights.repository.CategoryRepo;
import com.feedingindia.insights.repository.TransactionRepo;
import com.feedingindia.insights.service.TransactionService;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo transactionRepo;

    private final CategoryRepo categoryRepo;


    public TransactionServiceImpl(TransactionRepo transactionRepo, CategoryRepo categoryRepo){
        this.transactionRepo = transactionRepo;
        this.categoryRepo = categoryRepo;
    }



    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList = categoryRepo.findAllCategories();

        // TODO: Throw new Excpetion if categoriesList is empty
        return categoryList;
    }

    @Override
    public void recordTransaction(TransactionDTO transactionDTO) throws Exception {
       validateTransactionDTO(transactionDTO);
       Transaction transaction = copyTransactionDTOToTransaction(transactionDTO);
       transactionRepo.save(transaction);
    }


    private void validateTransactionDTO(TransactionDTO dto) throws RuntimeException {
        Integer id = dto.getCategoryId();
        if(!categoryRepo.existsById(id)){
            throw new RuntimeException();
        }
    }
    private Transaction copyTransactionDTOToTransaction(TransactionDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(dto.getDate());
        transaction.setAmount(dto.getAmount());
        transaction.setDescription(dto.getDescription());
        transaction.setCategoryId(dto.getCategoryId());
        return transaction;
    }
}
