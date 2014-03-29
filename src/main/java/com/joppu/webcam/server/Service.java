package com.joppu.webcam.server;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/api")
@Produces("text/plain")
public class Service {

    private String ip = null;

    @GET @Path("/homeip")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIp() {
        return ip;
    }

    @GET @Path("/homeip/{ip}")
    public String setIp(@PathParam("ip") String ip) {
        this.ip = ip;
	return "Yellow";
    }

}
