package com.assignment.dropbox.model;

import lombok.Data;
import java.util.List;

@Data
public class TeamEventResponse {
    private List<TeamEvent> events;
    private String cursor;
    private boolean hasMore;
}