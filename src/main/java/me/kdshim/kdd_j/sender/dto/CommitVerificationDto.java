package me.kdshim.kdd_j.sender.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CommitVerificationDto {
    private boolean verified;
    private String reason;
    private String signature;
    private String payload;
}
