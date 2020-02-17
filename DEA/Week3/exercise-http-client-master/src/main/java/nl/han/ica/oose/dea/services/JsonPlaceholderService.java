package nl.han.ica.oose.dea.services;

import nl.han.ica.oose.dea.services.dtos.TodoDto;
import nl.han.ica.oose.dea.services.mappers.TodoMapper;

import java.util.function.Consumer;

public class JsonPlaceholderService {

    private TodoMapper todoMapper;

    public JsonPlaceholderService() {
        todoMapper = new TodoMapper();
    }

    public void getTodos() {

    }

    public void getTodosWithCallback(Consumer<String> callback) {

    }

    public void createNewTodoItemOnServer(Consumer<String> callback) {

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
