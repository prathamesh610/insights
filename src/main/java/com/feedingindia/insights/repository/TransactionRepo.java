package com.feedingindia.insights.repository;

import com.feedingindia.insights.dtos.InsightsDTO;
import com.feedingindia.insights.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

    @Query("SELECT new com.feedingindia.insights.dtos.InsightsDTO(SUM(t.amount), c.categoryName) from Transaction t JOIN Category c on c.id = t.categoryId  WHERE t.transactionDate BETWEEN :from AND :to GROUP BY t.categoryId")
    List<InsightsDTO> getAllInsightsByTimePeriod(Date from, Date to);
}
