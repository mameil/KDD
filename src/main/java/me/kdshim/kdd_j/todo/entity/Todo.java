package me.kdshim.kdd_j.todo.entity;

import lombok.*;
import me.kdshim.kdd_j.common.BaseEntity;
import me.kdshim.kdd_j.swagger.model.GetTODODto;
import me.kdshim.kdd_j.swagger.model.PostTODODto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String todo;

    @Builder.Default
    private TodoStatus status = TodoStatus.UNDONE;

    private String endDate;

    public static Todo fromDto(PostTODODto dto){
        return Todo.builder()
                .todo(dto.getTodo())
                .endDate(dto.getEndDate())
                .build();
    }

    public static GetTODODto toDto(Todo entity){
        GetTODODto dto = new GetTODODto();
        dto.setId(Math.toIntExact(entity.getId()));
        dto.setTodo(entity.getTodo());
        dto.setEndDate(entity.getEndDate());
        dto.setStatus(GetTODODto.StatusEnum.valueOf(entity.getStatus().toString()));
        dto.setCreated(entity.getCreated().toString());
        dto.setUpdated(entity.getUpdated().toString());
        return dto;
    }
}
