package com.assignment.dropbox.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccessMethod {
    @JsonProperty(".tag")
    private String tag;
    private EndUser endUser;
}