package com.ttnAssignment.AssignmentRestAPI.error;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime localDateTime;
    private String errorMessage;
    private String description;

    public ErrorDetails(LocalDateTime localDateTime, String errorMessage, String description) {
        this.localDateTime = localDateTime;
        this.errorMessage = errorMessage;
        this.description = description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getDescription() {
        return description;
    }
}
