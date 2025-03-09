package dev.kkoncki;

import dev.kkoncki.response.GitHubReposResponse;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/github")
public class GitHubResource {

    @Inject
    GitHubService gitHubService;

    @GET
    @Path("{username}/repos")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<GitHubReposResponse>> getUserRepositories(@PathParam("username") String username) {
        return gitHubService.getNonForkRepositories(username);
    }

}
