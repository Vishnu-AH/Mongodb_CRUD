package com.pace.springMongoCrud.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookNotFoundException extends RuntimeException{
    private String message;

}
