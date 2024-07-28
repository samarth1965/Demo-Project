package com.delivery.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String fieldName;
    private Long fieldValue;


    public ResourceNotFoundException(String resource, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : %s",resource,fieldName,fieldValue));
        this.resource = resource;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
