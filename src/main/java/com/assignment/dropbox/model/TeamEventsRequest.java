package com.assignment.dropbox.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Request DTO for Dropbox /team_log/get_events API.
 */
@NoArgsConstructor
@Data
public class TeamEventsRequest {

    private int limit = 1000;

    private String accountId;

    private TimeRange time;

    private String category;

    private  String eventType;
}