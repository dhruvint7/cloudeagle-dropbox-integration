package com.assignment.dropbox.exception;

import lombok.Getter;

@Getter
public class DropboxApiException extends RuntimeException {
    private final int status;
    private final String rawBody;

    public DropboxApiException(int status, String rawBody) {
        super("Dropbox API error (status=" + status + ")");
        this.status = status;
        this.rawBody = rawBody;
    }
}
