package nl.han.oose.dea.rescources.services.exceptionmappers;

import nl.han.oose.dea.rescources.services.exceptions.IdAlreadyInUseException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IdAlreadyInUseExceptionMapper implements ExceptionMapper<IdAlreadyInUseException> {

    @Override
    public Response toResponse(IdAlreadyInUseException e) {
        return Response.status(409).build();
    }
}
