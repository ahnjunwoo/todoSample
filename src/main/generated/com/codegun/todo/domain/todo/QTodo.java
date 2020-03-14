package com.codegun.todo.domain.todo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTodo is a Querydsl query type for Todo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTodo extends EntityPathBase<Todo> {

    private static final long serialVersionUID = 669928932L;

    public static final QTodo todo = new QTodo("todo");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final SetPath<TodoRef, QTodoRef> refTodoIds = this.<TodoRef, QTodoRef>createSet("refTodoIds", TodoRef.class, QTodoRef.class, PathInits.DIRECT2);

    public final EnumPath<Status> status = createEnum("status", Status.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QTodo(String variable) {
        super(Todo.class, forVariable(variable));
    }

    public QTodo(Path<? extends Todo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTodo(PathMetadata metadata) {
        super(Todo.class, metadata);
    }

}

