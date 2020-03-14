package com.codegun.todo.interfaces.res.todo;

import com.codegun.todo.domain.todo.Status;
import com.codegun.todo.domain.todo.Todo;
import java.util.List;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
public class TodoResDTO {
  private String name;
  private Set<Long> refTodoIds;
  private Status status;

  @Builder
  public TodoResDTO(String name, Set<Long> refTodoIds,Status status) {
    this.name = name;
    this.refTodoIds = refTodoIds;
    this.status = status;
  }

  public static TodoResDTO toDTO(Todo todo) {
    return TodoResDTO.builder()
        .name(todo.getName())
        .status(todo.getStatus())
        //.refTodoIds(todo.getRefTodoIds())
        .build();
  }
}
