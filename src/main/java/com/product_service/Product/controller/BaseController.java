package com.product_service.Product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class BaseController<T> {

    protected ResponseEntity<T> createResponse(T body,HttpStatus status){
        return new ResponseEntity<>(body,status);
    }

    protected ResponseEntity<T> createOkResponse(T body) {

        return new ResponseEntity<>(body, HttpStatus.OK);
    }


    protected ResponseEntity<T> createInternalServerErrorResponse(T body) {
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    protected ResponseEntity<List<T>> createOkResponse(List<T> body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    protected ResponseEntity<List<T>> createInternalServerErrorResponse(List<T> body) {
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<T>createCreatedResponse(T body){
        return createResponse(body, HttpStatus.CREATED);
    }

    protected ResponseEntity<T>createBadRequestResponse(T body){
        return createResponse(body, HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<T>createNotFoundResponse(T body){
        return createResponse(body,HttpStatus.NOT_FOUND);
    }

    protected ResponseEntity<Void> createInternalServerErrorResponse(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
