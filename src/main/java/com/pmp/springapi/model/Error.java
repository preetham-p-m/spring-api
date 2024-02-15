package com.pmp.springapi.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Error {

    @NonNull
    private HttpStatus status;

    @NonNull
    private String message;

    private String stackTrace;

}
