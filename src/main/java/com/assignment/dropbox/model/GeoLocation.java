package com.assignment.dropbox.model;

import lombok.Data;

@Data
public class GeoLocation {
    private String city;
    private String region;
    private String country;
    private String ipAddress;
}