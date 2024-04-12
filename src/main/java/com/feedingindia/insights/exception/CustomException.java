package com.feedingindia.insights.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomException extends Exception{

    private ErrorCode errorCode;
    private String errorMessage;
}
