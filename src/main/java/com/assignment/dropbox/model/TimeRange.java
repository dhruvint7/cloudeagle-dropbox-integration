package com.assignment.dropbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

/**
 * Represents a time range filter for Dropbox events.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TimeRange {

    private Instant startTime;
    
    private Instant endTime;
}