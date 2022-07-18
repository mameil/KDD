package me.kdshim.kdd_j.todo.entity;

import me.kdshim.kdd_j.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String todo;

    private TodoStatus status = TodoStatus.TODO;

    private String doneDateString;

}
