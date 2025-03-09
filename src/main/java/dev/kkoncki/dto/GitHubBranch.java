package dev.kkoncki.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubBranch {
    public String name;
    public GitHubCommit commit;
}
