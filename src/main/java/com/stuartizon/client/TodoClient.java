package com.stuartizon.client;

import com.stuartizon.model.Todo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.http.HttpMethod.GET;

@Component
public class TodoClient {
    private final URI baseUrl;
    private final ExchangeFunction exchangeFunction;

    public TodoClient(@Value("${todos.service.url}") String baseUrl, ExchangeFunction exchangeFunction) {
        this.baseUrl = URI.create(baseUrl);
        this.exchangeFunction = exchangeFunction;
    }

    public Mono<Todo> getFirstTodo() {
        ClientRequest request = ClientRequest.create(GET, baseUrl.resolve("/todos/1")).build();

        return this.exchangeFunction
                .exchange(request)
                .flatMap(r -> r.bodyToMono(Todo.class));
    }
}
