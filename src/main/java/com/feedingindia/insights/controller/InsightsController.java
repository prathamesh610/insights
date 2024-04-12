package com.feedingindia.insights.controller;

import com.feedingindia.insights.dtos.InsightsTimelineDTO;
import com.feedingindia.insights.enums.InsightsTimelineEnum;
import com.feedingindia.insights.service.InsightsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/insights")
public class InsightsController {


    private final InsightsService insightsService;

    public InsightsController(InsightsService insightsService){
        this.insightsService = insightsService;
    }


    @GetMapping("/getInsightsByTimeline/{timeline}")
    public ResponseEntity<InsightsTimelineDTO> getInsightsByTimeline(@RequestParam(value = "timeline",defaultValue = "ONE_DAY")InsightsTimelineEnum timeline) {
        InsightsTimelineDTO insightsTimelineDTO = new InsightsTimelineDTO();
        try {
            insightsTimelineDTO =  insightsService.getInsights(timeline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(insightsTimelineDTO, HttpStatus.OK);
    }
}
