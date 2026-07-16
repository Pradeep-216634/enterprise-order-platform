package com.pradeep.orderservice.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ApiError(
        LocalDateTime timestamp,
        int status,
        String message,
        String path,
        String error,
        List<String> validationErrors) {
}
