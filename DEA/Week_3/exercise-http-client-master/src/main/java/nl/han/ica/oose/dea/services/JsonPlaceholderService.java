package nl.han.ica.oose.dea.services;

import nl.han.ica.oose.dea.services.dtos.TodoDto;
import nl.han.ica.oose.dea.services.mappers.TodoMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class JsonPlaceholderService {

    private TodoMapper todoMapper;
    private HttpClient httpClient;

    public JsonPlaceholderService() {
        todoMapper = new TodoMapper();
    }

    public void getTodos() {
        httpClient = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
                .build();


        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);


    }

    public void getTodosWithCallback(Consumer<String> callback) {
        httpClient = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
                .build();


        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(callback);
    }

    public void createNewTodoItemOnServer(Consumer<String> callback) {
        httpClient = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
                .build();


        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(response -> {
                            HttpRequest postRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
                                    .header("Content-Type", "application/json")
                                    .POST(HttpRequest.BodyPublishers.ofString(
                                            todoMapper.mapToJson(createNewTodoItem(todoMapper.mapToJava(response).length))))
                                    .build();

                            httpClient.sendAsync(postRequest, HttpResponse.BodyHandlers.ofString())
                                    .thenApply(HttpResponse::body)
                                    .thenAccept(callback);
                        }
                );
    }

    private TodoDto createNewTodoItem(int id) {
        var todo = new TodoDto();
        todo.setId(id);
        todo.setCompleted(false);
        todo.setTitle("Finish the DEA Exercise");
        todo.setUserId(2);
        return todo;
    }
}
