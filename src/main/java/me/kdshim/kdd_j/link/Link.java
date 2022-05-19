package me.kdshim.kdd_j.link;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Link {
    @Id
    private String url;
    private String category;
    private String name;
    private String desc;
}
