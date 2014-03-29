package com.joppu.webcam.server.services;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/homeip")
public class HomeIpService {

    private String ip = "192.168.1.79";

    @GET
    public String getIp() {
        return ip;
    }

    @GET
    @Path("/{ip}")
    @Produces(MediaType.TEXT_PLAIN)
    public String setIp(@PathParam("ip") String ip) {
        this.ip = ip;
        return "Yellow";
    }

}
