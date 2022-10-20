package com.blog.app.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {

        super(String.format("%s not found with %s", resourceName, fieldName, fieldValue));

        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
        this.fieldName = fieldName;

    }


}
