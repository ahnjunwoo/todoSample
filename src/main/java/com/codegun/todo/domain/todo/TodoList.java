package com.codegun.todo.domain.todo;

import com.codegun.todo.application.exception.InCompleteRefTodoException;
import com.codegun.todo.application.exception.RefNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoList {
  private List<Todo> todos;

  public TodoList(List<Todo> todos) {
    this.todos = todos;
  }

  public void validation(List<Long> todoReqDTO) {
    if (this.todos.size() != todoReqDTO.size()) {
      throw new RefNotFoundException();
    }
  }

  public void refCompleteCheck() {
    long incompleteCnt =  this.todos.stream().filter(todo -> todo.getStatus().equals(Status.INCOMPLETE)).count();
    if (incompleteCnt > 0) {
      throw new InCompleteRefTodoException();
    }
  }

  public Set<TodoRef> getRefTodoIds() {
    if (this.todos == null) {
      return Collections.emptySet();
    }
    return this.todos.stream().map(todo -> new TodoRef(todo.getId())).collect(Collectors.toSet());
  }

}
