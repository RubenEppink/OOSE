package nl.han.ica.oose.dea.services.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ItemNotAvailableExceptionMapper
        implements ExceptionMapper<ItemNotAvailableException> {

    @Override
    public Response toResponse(ItemNotAvailableException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }
}
