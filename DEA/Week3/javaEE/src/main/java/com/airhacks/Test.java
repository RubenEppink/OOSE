package com.airhacks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("yolo")
public class Test {

    @Path("lol")
    @GET
    public String lol() {
        return "pog";
    }
}
