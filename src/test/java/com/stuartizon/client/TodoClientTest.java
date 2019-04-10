package com.stuartizon.client;

import com.stuartizon.model.Todo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class TodoClientTest {
    @Test
    public void getFirstTodoSuccess() {
        Todo todo = new Todo(1, 2, "Hello", false);

//        System.err.println("ASDF" + todo.toString());
        Assert.assertEquals("Asdf", todo.toString());

        ExchangeFunction exchangeFunction = new ExchangeFunction() {
            @Override
            public Mono<ClientResponse> exchange(ClientRequest request) {
                return Mono.just(ClientResponse.create(OK).body(todo.toString()).header(CONTENT_TYPE, APPLICATION_JSON_VALUE).build());
            }
        };

        TodoClient client = new TodoClient("baseUrl", exchangeFunction);

        Assert.assertEquals("Hello world", client.getFirstTodo().block());
    }
}
