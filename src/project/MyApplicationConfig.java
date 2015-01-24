package project;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("flickr")
public class MyApplicationConfig extends ResourceConfig {
    public MyApplicationConfig () {
        packages("rest");
    }
}
