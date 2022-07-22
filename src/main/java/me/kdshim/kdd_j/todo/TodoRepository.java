package me.kdshim.kdd_j.todo;

import me.kdshim.kdd_j.todo.entity.Todo;
import me.kdshim.kdd_j.todo.entity.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, String> {
    List<Todo> findAllByStatus(TodoStatus status);
}
