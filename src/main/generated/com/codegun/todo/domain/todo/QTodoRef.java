package com.codegun.todo.domain.todo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTodoRef is a Querydsl query type for TodoRef
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QTodoRef extends BeanPath<TodoRef> {

    private static final long serialVersionUID = -860129265L;

    public static final QTodoRef todoRef = new QTodoRef("todoRef");

    public final NumberPath<Long> refTodoId = createNumber("refTodoId", Long.class);

    public QTodoRef(String variable) {
        super(TodoRef.class, forVariable(variable));
    }

    public QTodoRef(Path<? extends TodoRef> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTodoRef(PathMetadata metadata) {
        super(TodoRef.class, metadata);
    }

}

