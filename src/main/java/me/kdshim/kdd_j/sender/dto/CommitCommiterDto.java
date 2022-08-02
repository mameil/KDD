package me.kdshim.kdd_j.sender.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CommitCommiterDto {
    private String name;
    private String email;
    private String date;
}
