package com.codegun.todo.application.service;

import com.codegun.todo.domain.todo.Status;
import com.codegun.todo.domain.todo.Todo;
import com.codegun.todo.domain.todo.TodoList;
import com.codegun.todo.domain.todo.TodoRepository;
import com.codegun.todo.interfaces.req.todo.TodoAddReqDTO;
import com.codegun.todo.interfaces.req.todo.TodoUpdateReqDTO;
import com.codegun.todo.interfaces.res.todo.TodoResDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {

  private TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Transactional
  public TodoResDTO addTodo(TodoAddReqDTO todoAddReqDTO) {
    TodoList todoList = getRefTodos(todoAddReqDTO.getRefTodoIds());
    return TodoResDTO.toDTO(todoRepository.save(todoAddReqDTO.toEntity(todoList.getRefTodoIds())));
  }

  @Transactional
  public TodoResDTO updateTodo(Long id, TodoUpdateReqDTO todoUpdateReqDTO) {
    TodoList todoList = getRefTodos(todoUpdateReqDTO.getRefTodoIds());
    if (todoUpdateReqDTO.getStatus().equals(Status.COMPLETION)) {
      todoList.refCompleteCheck();
    }
    Optional<Todo> todo = todoRepository.findById(id);
    todo.ifPresent(value -> value.update(todoUpdateReqDTO, todoList.getRefTodoIds()));

    TodoResDTO todoResDTO = null;
    if (todo.isPresent()) {
      todoResDTO = TodoResDTO.toDTO(todo.get());
    }
    return todoResDTO;
  }

  private TodoList getRefTodos(List<Long> refTodoIds) {
    TodoList todoList = new TodoList();
    if (refTodoIds != null) {
      todoList = new TodoList(todoRepository.findByIdIn(refTodoIds));
      todoList.validation(refTodoIds);
    }
    return todoList;
  }
}
