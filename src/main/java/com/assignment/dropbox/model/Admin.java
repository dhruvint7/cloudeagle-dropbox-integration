package com.assignment.dropbox.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Admin {
    @JsonProperty(".tag")
    private String tag;
    private String accountId;
    private String displayName;
    private String email;
    private String teamMemberId;
}