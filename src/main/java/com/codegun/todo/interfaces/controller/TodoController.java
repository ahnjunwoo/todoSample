package com.codegun.todo.interfaces.controller;

import com.codegun.todo.application.exception.RefNotFoundException;
import com.codegun.todo.application.service.TodoService;
import com.codegun.todo.interfaces.req.todo.TodoAddReqDTO;
import com.codegun.todo.interfaces.req.todo.TodoUpdateReqDTO;
import com.codegun.todo.interfaces.res.todo.TodoResDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

  private TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @ApiOperation(value = "todo 등록")
  @ApiResponses({
      @ApiResponse(code = 200, message = "success",response = TodoResDTO.class)
  })
  @PostMapping(path = "v1/todos")
  public ResponseEntity<TodoResDTO> addTodo(@RequestBody @Valid TodoAddReqDTO todoAddReqDTO) {
    try {
      return ResponseEntity.ok(todoService.addTodo(todoAddReqDTO));
    } catch (RefNotFoundException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @ApiOperation(value = "todo 수정")
  @ApiResponses({
      @ApiResponse(code = 200, message = "success")
  })
  @PutMapping(path = "v1/todos/{todoId}")
  public ResponseEntity<TodoResDTO> updateTodo(
      @PathVariable("todoId") Long todoId,
      @RequestBody @Valid TodoUpdateReqDTO todoUpdateReqDTO) {
    try {
      return ResponseEntity.ok(todoService.updateTodo(todoId,todoUpdateReqDTO));
    } catch (RefNotFoundException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
