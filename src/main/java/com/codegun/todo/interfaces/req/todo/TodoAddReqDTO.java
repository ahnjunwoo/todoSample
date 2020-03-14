package com.codegun.todo.interfaces.req.todo;

import com.codegun.todo.domain.todo.Status;
import com.codegun.todo.domain.todo.Todo;
import com.codegun.todo.domain.todo.TodoRef;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
public class TodoAddReqDTO {
  @NonNull
  private String name;
  private List<Long> refTodoIds;

  @Builder
  public TodoAddReqDTO(String name, List<Long> refTodoIds) {
    this.name = name;
    this.refTodoIds = refTodoIds;
  }

  public Todo toEntity(Set<TodoRef> refTodoIds) {
    return Todo.builder()
        .name(this.name)
        .status(Status.INCOMPLETE)
        .refTodoIds(refTodoIds)
        .build();
  }
}
