package com.example.JWTNIKHIL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> arthmeticexception() {
        return new ResponseEntity<>("Your code has arthematic exception", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> NULLexception(NoSuchElementException e) {
        return new ResponseEntity<>("Your code has NULL exception" + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> Illegalexception(IllegalArgumentException e) {
        return new ResponseEntity<>("Your code has ILLegal exception" + e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(io.jsonwebtoken.JwtException.class)
    public ResponseEntity<String> handleJwtException(
            io.jsonwebtoken.JwtException e) {

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Invalid or expired JWT token");
    }


}
