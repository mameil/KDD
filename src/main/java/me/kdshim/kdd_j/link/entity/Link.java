package me.kdshim.kdd_j.link.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.kdshim.kdd_j.common.BaseEntity;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Link extends BaseEntity {
    private String url;
    private CATEGORY category;
    private String name;
    private String desc;

    public boolean checkCoke(String name){
        if(name.equals("나는콜라가좋아"))
            throw new IllegalArgumentException("콜라는 안돼요!");
        return true;
    }
}
