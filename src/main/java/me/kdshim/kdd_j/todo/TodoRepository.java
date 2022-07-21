package me.kdshim.kdd_j.todo;

import me.kdshim.kdd_j.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TodoRepository extends JpaRepository<Todo, String> {
}
