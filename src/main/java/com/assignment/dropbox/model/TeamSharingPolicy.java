package com.assignment.dropbox.model;

import lombok.Data;

/**
 * Represents sharing policies within and outside the team.
 */
@Data
public class TeamSharingPolicy {

    private Tag sharedFolderMemberPolicy;
    private Tag sharedFolderJoinPolicy;
    private Tag sharedLinkCreatePolicy;
    private Tag groupCreationPolicy;
    private Tag sharedFolderLinkRestrictionPolicy;
    private Tag enforceLinkPasswordPolicy;
    private Tag defaultLinkExpirationDaysPolicy;
    private Tag sharedLinkDefaultPermissionsPolicy;
}
