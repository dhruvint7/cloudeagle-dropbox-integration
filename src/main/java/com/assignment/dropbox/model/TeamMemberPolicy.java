package com.assignment.dropbox.model;

import lombok.Data;

/**
 * Represents the full set of team member policies returned by Dropbox API.
 * Jackson will auto-map snake_case JSON fields based on the global config.
 */
@Data
public class TeamMemberPolicy {

    private TeamSharingPolicy sharing;
    private Tag emmState;
    private Tag officeAddin;
    private Tag suggestMembersPolicy;
    private Tag topLevelContentPolicy;
}
