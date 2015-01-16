package rest.Deployment;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.people.User;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.tags.ClusterList;
import com.flickr4java.flickr.tags.TagsInterface;
import com.flickr4java.flickr.test.TestInterface;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server
{
    private static final URI BASE_URI = URI.create("http://localhost:8443/");

      public static void main(String[] args) throws Exception, IllegalArgumentException, IOException, URISyntaxException
    {
        System.out.println("Starting Flickr standalone HTTP server...");
        JdkHttpServerFactory.createHttpServer(BASE_URI, createApp());
        System.out.println("Server started on " + BASE_URI + "\n[kill the process to exit]");


    }
    public static ResourceConfig createApp() {
        return new MyApplicationConfig();
    }
}
