package dev.kkoncki.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class GitHubUserNotFoundException extends WebApplicationException {
    public GitHubUserNotFoundException(String username) {
        super(Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponse(404, "GitHub user " + username + " not found"))
                .build());
    }
}
