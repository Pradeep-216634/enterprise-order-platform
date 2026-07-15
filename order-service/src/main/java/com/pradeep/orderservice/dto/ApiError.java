package com.pradeep.orderservice.dto;

import java.time.LocalDateTime;

public record ApiError(
        LocalDateTime timestamp,
        int status,
        String message,
        String path) {
}
