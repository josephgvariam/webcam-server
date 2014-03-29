package com.joppu.webcam.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/api");

        ServletHolder servlets = new ServletHolder(new ServletContainer());
        servlets.setInitParameter("javax.ws.rs.Application", "com.joppu.webcam.server.Application");
        servlets.setInitOrder(1);
        servletContextHandler.addServlet(servlets, "/*");

        FilterHolder filters = new FilterHolder(new CrossOriginFilter());
        servletContextHandler.addFilter(filters, "/*", EnumSet.of(DispatcherType.REQUEST));

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase("app");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{servletContextHandler, resourceHandler, new DefaultHandler()});
        server.setHandler(handlers);

        LOG.log(Level.INFO, "Starting Webcam Server...");

        server.start();
        server.join();
    }
}
