package dev.kkoncki.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepo {
    public String name;
    public GitHubOwner owner;
    public boolean fork;
    public List<GitHubBranch> branches;
}
