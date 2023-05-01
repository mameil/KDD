package me.kdshim.kdd_j.sender.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostTransaction {
    private int amount;
    private String userId;
    private String registeredAt;
    private String registeredAtYyyymmdd;
    private String title;
    private String content;
    private int tagId;
    private String moneyType;
}
