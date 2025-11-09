package com.assignment.dropbox.model;

import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
public class TeamMemberProfile {

    private String teamMemberId;
    private String accountId;
    private String email;
    private boolean emailVerified;

    private Tag status;
    private Tag membershipType;

    private Name name;
    private String externalId;
    private List<String> groups;

    private String memberFolderId;
    private String rootFolderId;

    private List<SecondaryEmail> secondaryEmails;

    private Instant joinedOn;
    private Instant invitedOn;
    private Instant suspendedOn;

    private String persistentId;

    private Boolean isDirectoryRestricted;

    private String profilePhotoUrl;
}