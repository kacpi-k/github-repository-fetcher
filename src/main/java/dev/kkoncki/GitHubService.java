package dev.kkoncki;

import dev.kkoncki.exception.GitHubUserNotFoundException;
import dev.kkoncki.response.GitHubBranchResponse;
import dev.kkoncki.response.GitHubReposResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class GitHubService {

    @Inject
    @RestClient
    GitHubApiClient gitHubApiClient;

    public Uni<List<GitHubReposResponse>> getNonForkRepositories(String username) {
        return gitHubApiClient.getUserRepositories(username)
                .onFailure(WebApplicationException.class)
                .transform(ex -> {
                    if (((WebApplicationException) ex).getResponse().getStatus() == 404) {
                        return new GitHubUserNotFoundException(username);
                    }
                    return ex;
                })
                .onItem().transformToUni(repos -> {
                    List<Uni<GitHubReposResponse>> updatedRepos = repos.stream()
                            .filter(repo -> !repo.fork)
                            .map(repo -> gitHubApiClient.getBranches(repo.owner.login, repo.name)
                                    .onItem().transform(branches -> {
                                        List<GitHubBranchResponse> branchResponses = branches.stream()
                                                .map(branch -> new GitHubBranchResponse(branch.name, branch.commit.sha))
                                                .toList();

                                        return new GitHubReposResponse(repo.name, repo.owner.login, branchResponses);
                                    })
                            ).toList();

                    return Uni.join().all(updatedRepos).andCollectFailures();
                });
    }
}



