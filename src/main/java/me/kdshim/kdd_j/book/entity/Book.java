package me.kdshim.kdd_j.book.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Book {
    @Id
    private String id;
    private String name;
    private String url;
    private String recommender;
    private LocalDate created;

}
