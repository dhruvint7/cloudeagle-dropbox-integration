package com.assignment.dropbox.model;

import lombok.Data;
import java.util.List;

@Data
public class TeamMemberInfoV2 {
    private TeamMemberProfile profile;
    private List<TeamMemberRole> roles;
}