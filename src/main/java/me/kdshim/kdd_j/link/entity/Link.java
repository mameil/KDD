package me.kdshim.kdd_j.link.entity;

import lombok.Data;
import me.kdshim.kdd_j.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Link extends BaseEntity {
    private String url;
    private String category;
    private String name;
    private String desc;
}
