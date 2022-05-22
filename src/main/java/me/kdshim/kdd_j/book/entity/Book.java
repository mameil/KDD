package me.kdshim.kdd_j.book.entity;

import lombok.Data;
import me.kdshim.kdd_j.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Entity
@Data
public class Book extends BaseEntity {
    @Id
    private String id;
    private String name;
    private String url;
    private String recommender;

}
