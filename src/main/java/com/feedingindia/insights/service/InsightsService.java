package com.feedingindia.insights.service;

import com.feedingindia.insights.dtos.InsightsTimelineDTO;
import com.feedingindia.insights.enums.InsightsTimelineEnum;

public interface InsightsService {

    /**
     *  Get insights overall
     *  This method will take the timeline for insights
     *  and Return list of insights per category
     *  List<InsightsDTO>
     */
    // TODO: Create some enum for the insights.
    InsightsTimelineDTO getInsights(InsightsTimelineEnum insightsTimelineEnum) throws Exception;
}
