package com.example.Client.exception;

import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDetail{
    private LocalDateTime timeStamp;
    private String message;
    private String path;
    private String errorCode;
}
