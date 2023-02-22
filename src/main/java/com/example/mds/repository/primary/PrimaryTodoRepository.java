package com.example.mds.repository.primary;

import com.example.mds.entity.primary.PrimaryTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryTodoRepository extends JpaRepository<PrimaryTodo, Long> {
}
