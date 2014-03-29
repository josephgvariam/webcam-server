package com.joppu.webcam.server;

import com.joppu.webcam.server.services.HomeIpService;
import com.joppu.webcam.server.services.ImageUploadService;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import java.util.HashSet;
import java.util.Set;

public class Application extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();

        // register resources and features
        classes.add(MultiPartFeature.class);
        classes.add(ImageUploadService.class);
        classes.add(HomeIpService.class);
        classes.add(LoggingFilter.class);

        return classes;
    }
}
