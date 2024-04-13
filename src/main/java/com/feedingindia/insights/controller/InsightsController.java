package com.feedingindia.insights.controller;

import com.feedingindia.insights.dtos.InsightsTimelineDTO;
import com.feedingindia.insights.enums.InsightsTimelineEnum;
import com.feedingindia.insights.exception.CustomException;
import com.feedingindia.insights.exception.CustomExceptionHandler;
import com.feedingindia.insights.service.InsightsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/insights")
public class InsightsController {


    private final InsightsService insightsService;

    public InsightsController(InsightsService insightsService){
        this.insightsService = insightsService;
    }


    @GetMapping("/getAvailableInsightsTimeline")
    public ResponseEntity<?> getAvailableInsightsTimeline(){
        return new ResponseEntity<>(insightsService.getAvailableInsightsTimeline(), HttpStatus.OK);
    }

    @GetMapping("/getInsightsByTimeline/{timeline}")
    public ResponseEntity<InsightsTimelineDTO> getInsightsByTimeline(@RequestParam(value = "timeline",defaultValue = "ONE_DAY")InsightsTimelineEnum timeline) {
        InsightsTimelineDTO insightsTimelineDTO = new InsightsTimelineDTO();
        try {
            insightsTimelineDTO =  insightsService.getInsights(timeline);
        }catch (CustomException e){
            throw new CustomExceptionHandler.InsightsWrappedException(e);
        }catch (Exception e){
            throw new CustomExceptionHandler.WrappedException(e);
        }
        return new ResponseEntity<>(insightsTimelineDTO, HttpStatus.OK);
    }
}
