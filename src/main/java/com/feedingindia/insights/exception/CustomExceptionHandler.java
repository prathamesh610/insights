package com.feedingindia.insights.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class CustomExceptionHandler {

    public static class WrappedException extends RuntimeException {
        private static final long serialVersionUID = 8510741846770833279L;

        public WrappedException(Exception exception) {
            this.exception = exception;
        }

        private Exception exception;


    }

    public static class InsightsWrappedException extends RuntimeException {
        private static final long serialVersionUID = -5655485625215079008L;

        public InsightsWrappedException(CustomException customException) {
            this.customException = customException;
        }

        private CustomException customException;
    }

    @ExceptionHandler(WrappedException.class)
    @ResponseBody
    public ResponseEntity<String> handleException(WrappedException e) {
        return new ResponseEntity<>(ErrorCode.INTERNAL_SERVER_ERROR.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InsightsWrappedException.class)
    @ResponseBody
    public ResponseEntity<String> handleValidationException(InsightsWrappedException e) {
        return new ResponseEntity<>(e.customException.getErrorCode().toString() + " " +
                e.customException.getErrorMessage(), HttpStatus.FORBIDDEN);
    }

}
