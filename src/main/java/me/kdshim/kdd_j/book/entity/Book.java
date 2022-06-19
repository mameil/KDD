package me.kdshim.kdd_j.book.entity;

import lombok.*;
import me.kdshim.kdd_j.common.BaseEntity;
import me.kdshim.kdd_j.link.entity.Link;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;

    private String name;
    private String url;
    private String recommender;
    @ManyToOne
    @JoinColumn(name = "link_id")
    private Link link;

}
