package me.kdshim.kdd_j.book.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.kdshim.kdd_j.common.BaseEntity;
import me.kdshim.kdd_j.link.entity.Link;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity {
    private String name;
    private String url;
    private String recommender;
    @ManyToOne
    @JoinColumn(name = "link_id")
    private Link link;

}
