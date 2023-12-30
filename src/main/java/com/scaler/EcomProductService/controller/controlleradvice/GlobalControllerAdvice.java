package com.scaler.EcomProductService.controller.controlleradvice;

import com.scaler.EcomProductService.dto.ErrorResponseDTO;
import com.scaler.EcomProductService.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNullPointerException(Exception ex)
    {
        // we shall send the message and status code to customer
        ErrorResponseDTO errorResponse = new ErrorResponseDTO();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setMessageCode(404);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

}
