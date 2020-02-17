package nl.han.ica.oose.dea.services.mappers;

import com.google.gson.Gson;
import nl.han.ica.oose.dea.services.dtos.TodoDto;

public class TodoMapper {

    private Gson gson;

    public TodoMapper() {
        gson = new Gson();
    }

    public TodoDto[] mapToJava(String json) {
        TodoDto[] todoDtos = gson.fromJson(json, TodoDto[].class);
        return todoDtos;
    }

    public String mapToJson(TodoDto dto) {
        String json = gson.toJson(dto);
        return json;
    }
}
