package com.huynguyen.instagram.Error;

import com.huynguyen.instagram.Entities.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponeEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> userNotFoundExceptopn(UserNotFoundException userNotFoundException, WebRequest webRequest){
        ErrorMessage errorMessage = new ErrorMessage(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
    }
}
