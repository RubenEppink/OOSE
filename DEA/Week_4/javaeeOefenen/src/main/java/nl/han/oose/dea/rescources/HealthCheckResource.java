package nl.han.oose.dea.rescources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("health")
public class HealthCheckResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String healthy() {
        return "Up & Running!";
    }
}
