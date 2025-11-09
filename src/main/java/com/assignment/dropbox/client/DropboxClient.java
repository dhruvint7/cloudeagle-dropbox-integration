package com.assignment.dropbox.client;

import com.assignment.dropbox.config.DropboxFeignConfig;
import com.assignment.dropbox.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Feign client for communicating with Dropbox API endpoints.
 *
 * Each method here directly maps to a Dropbox API route.
 * The {@link DropboxFeignConfig} handles authentication, headers,
 * and error decoding globally, so individual methods stay clean.
 */
@FeignClient(
        name = "dropboxClient",
        url = "${dropbox.base-url}",
        configuration = DropboxFeignConfig.class
)
public interface DropboxClient {

    /**
     * Fetches general team information such as name, ID, and license details.
     *
     * Maps to Dropbox endpoint: POST /team/get_info
     */
    @PostMapping("/team/get_info")
    ResponseTeamInfo getTeamInfo();

    /**
     * Retrieves the list of team members.
     *
     * Maps to Dropbox endpoint: POST /team/members/list_v2
     * @param membersListRequest contains limit and includeRemoved options.
     */
    @PostMapping("/team/members/list_v2")
    MembersListResponse getMembers(@RequestBody MembersListRequest membersListRequest);

    /**
     * Fetches team events (audit logs) for the organization.
     *
     * Maps to Dropbox endpoint: POST /team_log/get_events
     * @param teamEventsRequest contains optional filters such as accountId, category, etc.
     */
    @PostMapping("/team_log/get_events")
    TeamEventResponse getEvents(@RequestBody TeamEventsRequest teamEventsRequest);
}
