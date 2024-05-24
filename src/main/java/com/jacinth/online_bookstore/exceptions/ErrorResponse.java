package com.jacinth.online_bookstore.exceptions;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private int status;

}
