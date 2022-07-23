package me.kdshim.kdd_j.todo.impl;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.swagger.api.TodoApiDelegate;
import me.kdshim.kdd_j.swagger.model.GetTODODto;
import me.kdshim.kdd_j.swagger.model.GetTodoDtoList;
import me.kdshim.kdd_j.swagger.model.PostTODODto;
import me.kdshim.kdd_j.todo.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoApiControllerImpl implements TodoApiDelegate {
    private final TodoService todoService;
    @Override
    public ResponseEntity<GetTODODto> postTODO(PostTODODto body) {
        return new ResponseEntity<>(todoService.postTodo(body), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GetTodoDtoList> getUndoneTodo() {
        GetTodoDtoList returnList = new GetTodoDtoList();
        returnList.setDtoList(todoService.getUndoneTodo());
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GetTodoDtoList> getAllTodo() {
        GetTodoDtoList returnList = new GetTodoDtoList();
        returnList.setDtoList(todoService.getAllTodo());
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }
}
