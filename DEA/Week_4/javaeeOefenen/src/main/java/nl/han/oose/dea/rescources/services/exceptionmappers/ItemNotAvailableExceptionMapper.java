package nl.han.oose.dea.rescources.services.exceptionmappers;

import nl.han.oose.dea.rescources.services.exceptions.ItemNotAvailableException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ItemNotAvailableExceptionMapper implements
        ExceptionMapper<ItemNotAvailableException> {
    @Override
    public Response toResponse(nl.han.oose.dea.rescources.services.exceptions.ItemNotAvailableException e) {
        return Response.status(404).build();
    }
}
