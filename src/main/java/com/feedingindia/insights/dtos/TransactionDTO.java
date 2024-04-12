package com.feedingindia.insights.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("date")
    private Date date;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("categoryId")
    private Integer categoryId;

    @JsonProperty("description")
    private String description;
}
