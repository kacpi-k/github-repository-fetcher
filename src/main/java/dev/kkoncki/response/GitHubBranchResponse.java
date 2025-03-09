package dev.kkoncki.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubBranchResponse {
    public String name;

    @JsonProperty("last_commit_sha")
    public String lastCommitSha;

    public GitHubBranchResponse(String name, String lastCommitSha) {
        this.name = name;
        this.lastCommitSha = lastCommitSha;
    }
}
