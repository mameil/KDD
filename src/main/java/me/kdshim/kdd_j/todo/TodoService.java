package me.kdshim.kdd_j.todo;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.kdshim.kdd_j.swagger.model.GetTODODto;
import me.kdshim.kdd_j.swagger.model.PostTODODto;
import me.kdshim.kdd_j.todo.entity.Todo;
import me.kdshim.kdd_j.todo.entity.TodoStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoService {
    private final TodoRepository todoRepository;

    public GetTODODto postTodo(PostTODODto dto){

        Todo todo = Todo.fromDto(dto);
        log.info(todo.toString());
        Todo saved = todoRepository.save(todo);

        return Todo.toDto(saved);
    }

    public List<GetTODODto> getUndoneTodo(){
        List<GetTODODto> list = new ArrayList<>();
        todoRepository.findAllByStatus(TodoStatus.UNDONE).forEach(
                todo -> {
                    list.add(Todo.toDto(todo));
                }
        );
        return list;
    }
}
