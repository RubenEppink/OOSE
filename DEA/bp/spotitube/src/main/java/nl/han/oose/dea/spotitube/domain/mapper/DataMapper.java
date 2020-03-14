package nl.han.oose.dea.spotitube.domain.mapper;

import java.sql.ResultSet;

public interface DataMapper<T> {
    T toDTO(ResultSet resultset);
}
