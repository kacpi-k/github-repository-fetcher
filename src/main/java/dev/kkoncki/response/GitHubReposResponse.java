package dev.kkoncki.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GitHubReposResponse {
    @JsonProperty("repository_name")
    public String repositoryName;

    @JsonProperty("owner_login")
    public String ownerLogin;
    public List<GitHubBranchResponse> branches;

    public GitHubReposResponse(String repositoryName, String ownerLogin, List<GitHubBranchResponse> branches) {
        this.repositoryName = repositoryName;
        this.ownerLogin = ownerLogin;
        this.branches = branches;
    }
}
