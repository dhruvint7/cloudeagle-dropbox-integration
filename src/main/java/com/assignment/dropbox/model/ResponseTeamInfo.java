package com.assignment.dropbox.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTeamInfo {
    private String name;
    private String teamId;
    private int numLicensedUsers;
    private int numProvisionedUsers;
    private TeamMemberPolicy policies;
    private int numUsedLicenses;
}
