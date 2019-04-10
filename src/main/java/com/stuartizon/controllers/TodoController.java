package com.stuartizon.controllers;

import com.stuartizon.client.TodoClient;
import com.stuartizon.model.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TodoController {
    private final TodoClient client;

    public TodoController(TodoClient client) {
        this.client = client;
    }

    @GetMapping("/")
    private Mono<Todo> todo() {
        return client.getFirstTodo();
    }
}