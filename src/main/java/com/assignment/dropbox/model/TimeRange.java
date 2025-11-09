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

    /** Optional starting time (inclusive). */
    private Instant startTime;

    /** Optional ending time (exclusive). */
    private Instant endTime;
}