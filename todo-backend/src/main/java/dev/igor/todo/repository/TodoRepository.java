package dev.igor.todo.repository;

import dev.igor.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query("SELECT t FROM Todo t WHERE t.finished = false ORDER BY t.dateToFinish")
    List<Todo> findAllOpen();

    @Query("SELECT t FROM Todo t WHERE t.finished = true ORDER BY t.dateToFinish")
    List<Todo> findAllClose();
}
