package dev.kkoncki;

import dev.kkoncki.dto.GitHubBranch;
import dev.kkoncki.dto.GitHubRepo;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/")
@RegisterRestClient(baseUri = "https://api.github.com")
public interface GitHubApiClient {

    @GET
    @Path("/users/{owner}/repos")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<GitHubRepo>> getUserRepositories(
            @PathParam("owner") String username
    );

    @GET
    @Path("/repos/{owner}/{repo}/branches")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<GitHubBranch>> getBranches(
            @PathParam("owner") String owner,
            @PathParam("repo") String repo
    );
}
