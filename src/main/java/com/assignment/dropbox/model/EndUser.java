package com.assignment.dropbox.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EndUser {
    @JsonProperty(".tag")
    private String tag;
    private String sessionId;
}