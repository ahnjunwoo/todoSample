package com.codegun.todo.domain.todo;

import com.codegun.todo.interfaces.req.todo.TodoUpdateReqDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "todo")
@NoArgsConstructor
@Getter
public class Todo {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;

  @Column(length = 50)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(length = 10)
  private Status status;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "ref_todo", joinColumns = @JoinColumn(name = "id"), uniqueConstraints = {
      @UniqueConstraint(columnNames = {"id", "refTodoId"})
  })
  private Set<TodoRef> refTodoIds;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Builder
  public Todo(String name, Status status,Set<TodoRef> refTodoIds) {
    this.name = name;
    this.status = status;
    this.refTodoIds = refTodoIds;
  }

  public void update(TodoUpdateReqDTO todoUpdateReqDTO,
      Set<TodoRef> refTodoIds) {
    this.status = todoUpdateReqDTO.getStatus();
    this.name = todoUpdateReqDTO.getName();
    if (refTodoIds != null && !refTodoIds.isEmpty() ) {
      this.refTodoIds = refTodoIds;
    }
  }
}
