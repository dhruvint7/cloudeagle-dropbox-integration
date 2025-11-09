package com.assignment.dropbox.model;

import lombok.Data;

@Data
public class SecondaryEmail {
    private String email;
    private boolean verified;
}