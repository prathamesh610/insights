package com.feedingindia.insights.dtos;

import com.feedingindia.insights.enums.InsightsTimelineEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsightsTimelineDTO {
    private InsightsTimelineEnum timeline;
    private Double min;
    private Double max;
    private List<InsightsDTO> insightsDTOList;
}
