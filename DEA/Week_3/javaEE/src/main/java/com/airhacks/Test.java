package com.airhacks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class Test {
    @GET
    @Path("hallo")
    public String helloWorldEndPoint(){
        return "HALLOOOOOO";
    }
}
