package me.kdshim.kdd_j.sender.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CommitDto {
    private CommitAuthorDto author;
    private CommitCommiterDto commiter;
    private String message; // 요게 결국 필요한 커밋 메세지
    private CommitTreeDto tree;
    private String url;
    private int comment_count;
    private CommitVerificationDto verification;

}
