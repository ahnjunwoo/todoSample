package com.codegun.todo.domain.todo;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Access(AccessType.FIELD)
@NoArgsConstructor
@Getter
public class TodoRef {
    @Column(length = 40)
    private long refTodoId;

    public TodoRef(Long refTodoId) {
        this.refTodoId = refTodoId;
    }
}
