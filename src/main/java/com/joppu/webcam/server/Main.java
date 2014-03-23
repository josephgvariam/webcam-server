package com.joppu.webcam.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception{

        URI baseUri = UriBuilder.fromUri("http://localhost/").port(80).build();

        final ResourceConfig resourceConfig = new ResourceConfig(ImageUpload.class);
        resourceConfig.registerInstances(new LoggingFilter(LOG, true));
        resourceConfig.register(MultiPartFeature.class);

        Server server = JettyHttpContainerFactory.createServer(baseUri, resourceConfig);

        LOG.log(Level.INFO, "Starting Webcam Server...");

        server.start();
        server.join();
    }
}
