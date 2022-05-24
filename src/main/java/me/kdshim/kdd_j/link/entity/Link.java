package me.kdshim.kdd_j.link.entity;

import lombok.Data;
import me.kdshim.kdd_j.common.BaseEntity;

import javax.persistence.Entity;

@Entity
@Data
public class Link extends BaseEntity {
    private String url;
    private String category;
    private String name;
    private String desc;

    public boolean checkCoke(String name){
        if(name.equals("나는콜라가좋아"))
            throw new IllegalArgumentException("콜라는 안돼요!");
        return true;
    }
}
