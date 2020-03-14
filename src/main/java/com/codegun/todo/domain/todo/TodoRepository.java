package com.codegun.todo.domain.todo;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {

  List<Todo> findByIdIn(List<Long> id);

}
