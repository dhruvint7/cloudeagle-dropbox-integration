package com.assignment.dropbox.model;

import lombok.Data;
import java.util.List;

@Data
public class MembersListResponse {
    private List<TeamMemberInfoV2> members;
    private boolean hasMore;
    private String cursor;
}