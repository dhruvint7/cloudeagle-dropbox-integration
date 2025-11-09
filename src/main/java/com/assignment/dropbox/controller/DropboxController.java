package com.assignment.dropbox.controller;

import com.assignment.dropbox.model.*;
import com.assignment.dropbox.service.DropboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Handles all Dropbox-related endpoints.
 *
 * Exposes APIs to fetch team info, list members, and view team activity events.
 * Keeps the controller layer light — everything is delegated to the service layer.
 */
@RestController
@RequestMapping("/dropbox")
@RequiredArgsConstructor
public class DropboxController {

    private final DropboxService dropboxService;

    /**
     * Returns only the team name.
     *
     * This is a quick, lightweight call if you just need the team’s display name.
     */
    @PostMapping("/team-name")
    public ResponseEntity<String> getTeamName() {
        ResponseTeamInfo teamInfo = dropboxService.getTeamInfoV2();
        return ResponseEntity.ok(teamInfo.getName());
    }

    /**
     * Returns complete team details such as name, ID, licenses, and policies.
     */
    @PostMapping("/team")
    public ResponseEntity<ResponseTeamInfo> getTeamInfo() {
        ResponseTeamInfo teamInfo = dropboxService.getTeamInfoV2();
        return ResponseEntity.ok(teamInfo);
    }

    /**
     * Lists members in the Dropbox team.
     *
     * You can pass a custom limit or choose whether to include removed members.
     * Example:
     * {
     *   "limit": 10,
     *   "includeRemoved": false
     * }
     */
    @PostMapping("/list-members")
    public ResponseEntity<MembersListResponse> getMembers(@RequestBody MembersListRequest request) {
        MembersListResponse response = dropboxService.getMembers(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Fetches team activity or audit events.
     *
     * You can filter events by category (e.g. "logins") or by event type.
     * Example:
     * {
     *   "limit": 5,
     *   "category": "logins"
     * }
     */
    @PostMapping("/events")
    public ResponseEntity<TeamEventResponse> getEvents(@RequestBody TeamEventsRequest request) {
        TeamEventResponse response = dropboxService.getEvents(request);
        return ResponseEntity.ok(response);
    }
}
