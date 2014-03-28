package com.joppu.webcam.server;

import javax.inject.Singleton;
import javax.ws.rs.*;

@Singleton
@Path("/api")
@Produces("text/plain")
public class Service {

    private String ip = null;

    @GET @Path("/homeip")
    @Produces("text/plain")
    public String getIp() {
        return ip;
    }

    @GET @Path("/homeip/{ip}")
    public void setIp(@PathParam("ip") String ip) {
        this.ip = ip;
    }

}
