package com.feedingindia.insights.controller;

import com.feedingindia.insights.dtos.TransactionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/api")
public class ApiController {

    @GetMapping("/get-all-categories")
    public ResponseEntity<Map<Integer, String>> getAllCategories(){
        return new ResponseEntity<>(new HashMap<>(), HttpStatus.OK);
    }

    @PostMapping("/record-transaction")
    public ResponseEntity<String> recordTransaction(@RequestBody TransactionDTO transactionDTO){


        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
