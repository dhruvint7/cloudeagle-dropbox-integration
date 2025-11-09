package com.assignment.dropbox.controller;

import com.assignment.dropbox.model.*;
import com.assignment.dropbox.service.DropboxService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link DropboxController}.
 *
 * Keeps focus on controller-level behavior and ensures
 * correct communication with the service layer.
 */
@ExtendWith(MockitoExtension.class)
class DropboxControllerTest {

    @Mock
    private DropboxService dropboxService;

    @InjectMocks
    private DropboxController dropboxController;

    @Test
    void shouldReturnTeamName() {
        // given
        ResponseTeamInfo mockInfo = ResponseTeamInfo.builder()
                .name("BMS Engineering Team")
                .teamId("dbtid:12345")
                .build();

        when(dropboxService.getTeamInfoV2()).thenReturn(mockInfo);

        // when
        ResponseEntity<String> response = dropboxController.getTeamName();

        // then
        assertEquals("BMS Engineering Team", response.getBody());
    }

    @Test
    void shouldReturnTeamInfo() {
        // given
        ResponseTeamInfo mockInfo = ResponseTeamInfo.builder()
                .name("BookMyShow Tech")
                .numLicensedUsers(10)
                .numUsedLicenses(8)
                .build();

        when(dropboxService.getTeamInfoV2()).thenReturn(mockInfo);

        // when
        ResponseEntity<ResponseTeamInfo> response = dropboxController.getTeamInfo();

        // then
        assertEquals(mockInfo, response.getBody());
    }

    @Test
    void shouldReturnMembersList() {
        // given
        MembersListRequest request = new MembersListRequest();
        request.setLimit(5);
        request.setIncludeRemoved(false);

        MembersListResponse mockResponse = new MembersListResponse();

        when(dropboxService.getMembers(request)).thenReturn(mockResponse);

        // when
        ResponseEntity<MembersListResponse> response = dropboxController.getMembers(request);

        // then
        assertEquals(mockResponse, response.getBody());
    }

    @Test
    void shouldReturnEvents() {
        // given
        TeamEventsRequest request = new TeamEventsRequest();
        request.setLimit(10);
        request.setCategory("logins");

        TeamEventResponse mockResponse = new TeamEventResponse();

        when(dropboxService.getEvents(request)).thenReturn(mockResponse);

        // when
        ResponseEntity<TeamEventResponse> response = dropboxController.getEvents(request);

        // then
        assertEquals(mockResponse, response.getBody());
    }
}
