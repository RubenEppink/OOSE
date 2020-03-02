package com.airhacks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class Test {

    @GET
    @Path("tester")
    public String yolo() {
        return "yolo";

    }
}
