package com.assignment.dropbox.service;

import com.assignment.dropbox.client.DropboxClient;
import com.assignment.dropbox.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service layer for all Dropbox API interactions.
 *
 * This class simply delegates calls to the Feign client (DropboxClient)
 * and returns the responses as-is. It keeps things clean and makes it easy
 * to add caching, logging, or transformations later if needed.
 */
@Service
@RequiredArgsConstructor
public class DropboxService {

    private final DropboxClient dropboxClient;

    /**
     * Fetches complete team details such as name, team ID,
     * license count, and other metadata.
     */
    public ResponseTeamInfo getTeamInfoV2() {
        ResponseTeamInfo responseTeamInfo = dropboxClient.getTeamInfo();
        return responseTeamInfo;
    }

    /**
     * Retrieves the list of all team members.
     * The request can include limit or includeRemoved filters.
     */
    public MembersListResponse getMembers(MembersListRequest membersListRequest) {
        MembersListResponse membersListResponse = dropboxClient.getMembers(membersListRequest);
        return membersListResponse;
    }

    /**
     * Fetches team events or activity logs from Dropbox.
     * You can pass filters like category, accountId, or time range.
     */
    public TeamEventResponse getEvents(TeamEventsRequest teamEventsRequest) {
        TeamEventResponse teamEventResponse = dropboxClient.getEvents(teamEventsRequest);
        return teamEventResponse;
    }
}
