package me.kdshim.kdd_j.todo;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.kdshim.kdd_j.swagger.model.GetTODODto;
import me.kdshim.kdd_j.swagger.model.PostTODODto;
import me.kdshim.kdd_j.todo.entity.Todo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoService {
    private final TodoRepository todoRepository;

    public GetTODODto postTodo(PostTODODto dto){
        Todo todo = Todo.builder()
                .todo(dto.getTodo())
                .endDate(dto.getEndDate())
                .build();
        log.info(todo.toString());
        Todo saved = todoRepository.save(todo);
        GetTODODto fromEntity = new GetTODODto();
        fromEntity.setTodo(saved.getTodo());
        fromEntity.setId(saved.getId().intValue());
        fromEntity.setStatus(saved.getStatus().toString());
        fromEntity.setEndDate(saved.getEndDate());
        fromEntity.setCreated(saved.getCreated().toString());
        fromEntity.setUpdated(saved.getUpdated().toString());

        return fromEntity;
    }
}
