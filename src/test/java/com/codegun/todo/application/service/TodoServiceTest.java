package com.codegun.todo.application.service;

import com.codegun.todo.domain.todo.Status;
import com.codegun.todo.interfaces.req.todo.TodoAddReqDTO;
import com.codegun.todo.interfaces.req.todo.TodoUpdateReqDTO;
import com.codegun.todo.interfaces.res.todo.TodoResDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TodoServiceTest {

  @Autowired
  private TodoService todoService;

  @BeforeEach
  void setUp() {
  }

  @Test
  public void addTodo() {
    TodoAddReqDTO todoAddReqDTO = TodoAddReqDTO.builder()
        .name("TODO 3")
        .refTodoIds(null)
        .build();
    TodoResDTO todoResDTO = todoService.addTodo(todoAddReqDTO);
  }

  @Test
  public void addTodoWithRefTodo() {
    List<Long> todos = new ArrayList<>();
    todos.add(1L);
    todos.add(2L);
    TodoAddReqDTO todoAddReqDTO = TodoAddReqDTO.builder()
        .name("TODO 4")
        .refTodoIds(todos)
        .build();
    TodoResDTO todoResDTO = todoService.addTodo(todoAddReqDTO);
  }

  @Test
  public void updateTodo() {
    Long id = 4L;
    List<Long> todos = new ArrayList<>();
    todos.add(1L);
    todos.add(3L);
    TodoUpdateReqDTO todoUpdateReqDTO = TodoUpdateReqDTO.builder()
        .name("TODO 4-완료")
        .refTodoIds(todos)
        .status(Status.COMPLETION)
        .build();
    TodoResDTO todoResDTO = todoService.updateTodo(id, todoUpdateReqDTO);
  }

  @Test
  public void updateTodoWithRefTodos() {
    Long id = 4L;
    List<Long> todos = new ArrayList<>();
    todos.add(1L);
    todos.add(3L);
    TodoUpdateReqDTO todoUpdateReqDTO = TodoUpdateReqDTO.builder()
        .name("TODO 4-수정")
        .refTodoIds(todos)
        .status(Status.INCOMPLETE)
        .build();
    TodoResDTO todoResDTO = todoService.updateTodo(id, todoUpdateReqDTO);
  }

  @AfterEach
  void tearDown() {
  }
}