package com.assignment.dropbox.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Details {
    @JsonProperty(".tag")
    private String tag;
    private boolean isEmmManaged;
    private LoginMethod loginMethod;
}