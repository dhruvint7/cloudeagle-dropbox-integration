package com.assignment.dropbox.model;

import lombok.Data;

@Data
public class Origin {
    private GeoLocation geoLocation;
    private AccessMethod accessMethod;
}