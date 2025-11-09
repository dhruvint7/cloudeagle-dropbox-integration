package com.assignment.dropbox.service;

import com.assignment.dropbox.client.DropboxClient;
import com.assignment.dropbox.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link DropboxService}.
 *
 * Focuses on verifying that the service correctly delegates
 * calls to the {@link DropboxClient} and returns expected responses.
 */
@ExtendWith(MockitoExtension.class)
class DropboxServiceTest {

    @Mock
    private DropboxClient dropboxClient;

    @InjectMocks
    private DropboxService dropboxService;

    @Test
    void shouldReturnTeamInfoSuccessfully() {
        // given
        ResponseTeamInfo mockResponse = ResponseTeamInfo.builder()
                .name("BookMyShow Team")
                .build();

        when(dropboxClient.getTeamInfo()).thenReturn(mockResponse);

        // when
        ResponseTeamInfo result = dropboxService.getTeamInfoV2();

        // then
        assertEquals("BookMyShow Team", result.getName());
    }

    @Test
    void shouldReturnMembersList() {
        // given
        MembersListRequest request = new MembersListRequest();
        request.setLimit(5);
        request.setIncludeRemoved(false);

        MembersListResponse mockResponse = new MembersListResponse();

        when(dropboxClient.getMembers(request)).thenReturn(mockResponse);

        // when
        MembersListResponse result = dropboxService.getMembers(request);

        // then
        assertEquals(mockResponse, result);
    }

    @Test
    void shouldReturnTeamEvents() {
        // given
        TeamEventsRequest request = new TeamEventsRequest();
        request.setLimit(10);
        request.setCategory("logins");

        TeamEventResponse mockResponse = new TeamEventResponse();

        when(dropboxClient.getEvents(request)).thenReturn(mockResponse);

        // when
        TeamEventResponse result = dropboxService.getEvents(request);

        // then
        assertEquals(mockResponse, result);
    }
}
