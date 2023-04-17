package com.pace.springMongoCrud.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiErrorResponse {
    private String message;
    private int httpStatus;
    private Object data;
}
