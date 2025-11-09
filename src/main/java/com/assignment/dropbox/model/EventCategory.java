package com.assignment.dropbox.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EventCategory {
    @JsonProperty(".tag")
    private String tag;
}