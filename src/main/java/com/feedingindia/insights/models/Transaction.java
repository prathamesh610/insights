package com.feedingindia.insights.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Integer id;

    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "description")
    private String description;


}
