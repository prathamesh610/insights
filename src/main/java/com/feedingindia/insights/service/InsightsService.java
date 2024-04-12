package com.feedingindia.insights.service;

import com.feedingindia.insights.dtos.InsightsTimelineDTO;
import com.feedingindia.insights.enums.InsightsTimelineEnum;

import java.util.List;

public interface InsightsService {

    InsightsTimelineDTO getInsights(InsightsTimelineEnum insightsTimelineEnum) throws Exception;

    List<InsightsTimelineEnum> getAvailableInsightsTimeline();
}
