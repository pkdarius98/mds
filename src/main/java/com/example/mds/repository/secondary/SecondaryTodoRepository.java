package com.example.mds.repository.secondary;

import com.example.mds.entity.secondary.SecondaryTodo;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface SecondaryTodoRepository extends JpaRepository<SecondaryTodo, Long> {
}
