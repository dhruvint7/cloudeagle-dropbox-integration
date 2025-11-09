package com.assignment.dropbox.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Actor {
    @JsonProperty(".tag")
    private String tag;
    private Admin admin;
}