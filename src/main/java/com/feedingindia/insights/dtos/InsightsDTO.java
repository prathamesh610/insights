package com.feedingindia.insights.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsightsDTO {
    private Double amount;
    private String categoryName;

}
