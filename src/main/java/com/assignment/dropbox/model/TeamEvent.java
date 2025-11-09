package com.assignment.dropbox.model;

import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
public class TeamEvent {
    private Instant timestamp;
    private EventCategory eventCategory;
    private Actor actor;
    private Origin origin;
    private boolean involveNonTeamMember;
    private Context context;
    private List<Object> participants;
    private List<Object> assets;
    private EventType eventType;
    private Details details;
}