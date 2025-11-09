package com.assignment.dropbox.model;

import lombok.Data;

@Data
public class Name {
    private String givenName;
    private String surname;
    private String familiarName;
    private String displayName;
    private String abbreviatedName;
}