package me.kdshim.kdd_j.sender.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class getCommitDto {
    private String sha;
    private String node_id;
    private CommitDto commit;
    private String url;
    private String html_url;
    private String comments_url;
    private getCommitAuthorDto author;
    private getCommitAuthorDto committer;
    private List<CommitParentsDto> parents;
}
