package com.codegun.todo.interfaces.req.todo;

import com.codegun.todo.domain.todo.Status;
import com.codegun.todo.domain.todo.Todo;
import java.util.List;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
public class TodoUpdateReqDTO {
  @NonNull
  private String name;
  private List<Long> refTodoIds;
  private Status status;


  @Builder
  public TodoUpdateReqDTO(String name, List<Long> refTodoIds,Status status) {
    this.name = name;
    this.refTodoIds = refTodoIds;
    this.status = status;
  }

  public Todo toEntity(Set<Long> todos) {
    return Todo.builder()
        .name(this.name)
        .status(this.status)
        //.refTodoIds(todos)
        .build();
  }
}
