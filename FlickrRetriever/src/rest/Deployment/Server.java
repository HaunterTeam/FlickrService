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

    //deployment url
    //private static final URI BASE_URI = URI.create("http://localhost:443/mirko-morandi/");
    public static void main(String[] args) throws Exception, IllegalArgumentException, IOException, URISyntaxException
    {
        System.out.println("Starting Flickr standalone HTTP server...");
        JdkHttpServerFactory.createHttpServer(BASE_URI, createApp());
        System.out.println("Server started on " + BASE_URI + "\n[kill the process to exit]");

        /**String apiKey = "ba89157f14a6ae5a17772e71b94831f0";
        String sharedSecret = "855b1947ced1b8d3";
        Flickr f = new Flickr(apiKey, sharedSecret, new REST());
        TestInterface testInterface = f.getTestInterface();

        TagsInterface tagsInterface = f.getTagsInterface();
        PhotoList<Photo> list = tagsInterface.getClusterPhotos("pizza","1");

        Random rmd = new Random();

        int photo_index = rmd.nextInt(list.size());

        Photo photo = list.get(photo_index);


        Collection results = testInterface.echo(Collections.EMPTY_MAP);
        User flickr_user = testInterface.login();**/


        //System.out.println("Done");

    }
    public static ResourceConfig createApp() {
        return new MyApplicationConfig();
    }
}
