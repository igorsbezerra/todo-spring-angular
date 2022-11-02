package dev.igor.todo.service;

import dev.igor.todo.domain.Todo;
import dev.igor.todo.exceptions.ObjectNotFoundException;
import dev.igor.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo findById(Integer id) {
        return todoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Todo> findAllOpen() {
        return todoRepository.findAllOpen();
    }

    public List<Todo> findAllClose() {
        return todoRepository.findAllClose();
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo create(Todo todo) {
        todo.setId(null);
        return todoRepository.save(todo);
    }

    public void delete(Integer id) {
        todoRepository.deleteById(id);
    }

    public Todo update(Integer id, Todo todo) {
        todo.setId(id);
        return todoRepository.save(todo);
    }
}
