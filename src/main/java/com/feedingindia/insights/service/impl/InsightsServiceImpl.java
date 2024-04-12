package com.feedingindia.insights.service.impl;

import com.feedingindia.insights.dtos.InsightsDTO;
import com.feedingindia.insights.dtos.InsightsTimelineDTO;
import com.feedingindia.insights.enums.InsightsTimelineEnum;
import com.feedingindia.insights.repository.TransactionRepo;
import com.feedingindia.insights.service.InsightsService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class InsightsServiceImpl implements InsightsService {

    private final TransactionRepo transactionRepo;

    public InsightsServiceImpl(TransactionRepo transactionRepo){
        this.transactionRepo = transactionRepo;
    }

    @Override
    public InsightsTimelineDTO getInsights(InsightsTimelineEnum insightsTimelineEnum) throws Exception {
        InsightsTimelineDTO insightsTimelineDTO = new InsightsTimelineDTO();
        insightsTimelineDTO.setTimeline(insightsTimelineEnum);

        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        Date prevDate = null;

        switch (insightsTimelineEnum) {
            case ONE_DAY -> {
                cal.add(Calendar.DATE, -1);
            }
            case ONE_WEEK -> {
                cal.add(Calendar.DATE, -7);
            }
            case ONE_MONTH -> {
                cal.add(Calendar.MONTH, -1);
            }
            case ONE_YEAR -> {
                cal.add(Calendar.YEAR, -1);
            }
            case SIX_MONTHS -> {
                cal.add(Calendar.MONTH, -6);
            }

            default -> throw new Exception();
        }
        prevDate = cal.getTime();
        List<InsightsDTO> insightsEntityDTOList = transactionRepo.getAllInsightsByTimePeriod(prevDate, currentDate);

        insightsTimelineDTO.setInsightsDTOList(insightsEntityDTOList);

        calculateMinAndMax(insightsTimelineDTO);

        return insightsTimelineDTO;
    }


    private void calculateMinAndMax(InsightsTimelineDTO insightsTimelineDTO) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for(InsightsDTO insightsDTO : insightsTimelineDTO.getInsightsDTOList()){
            Double temp = insightsDTO.getAmount();
            if(temp > max) max = temp;
            if(temp < min) min = temp;
        }
        // To calculate what should be the min point on the graph.
        min /= 2;
        insightsTimelineDTO.setMin(min);
        insightsTimelineDTO.setMax(max);
    }

}
