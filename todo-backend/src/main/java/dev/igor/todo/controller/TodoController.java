package dev.igor.todo.controller;

import dev.igor.todo.domain.Todo;
import dev.igor.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/todos")
@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(todoService.findById(id));
    }

    @GetMapping("/open")
    public ResponseEntity<List<Todo>> findAllOpen() {
        return ResponseEntity.ok().body(todoService.findAllOpen());
    }

    @GetMapping("/close")
    public ResponseEntity<List<Todo>> findAllClose() {
        return ResponseEntity.ok().body(todoService.findAllClose());
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok().body(todoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        System.out.println(todo);
        var todoCreated = todoService.create(todo);
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(todoCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(todoCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo todo) {
        return ResponseEntity.ok().body(todoService.update(id, todo));
    }
}
