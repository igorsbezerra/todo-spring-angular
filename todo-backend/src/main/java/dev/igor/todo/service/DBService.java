package dev.igor.todo.service;

import dev.igor.todo.domain.Todo;
import dev.igor.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DBService {

    private final TodoRepository todoRepository;

    public DBService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void databaseInstance() {
        Todo todo = new Todo(null, "Estudar", "Estudar Spring Boot e Angular", LocalDate.parse("2022-01-01"), false);
        todoRepository.save(todo);
    }
}
