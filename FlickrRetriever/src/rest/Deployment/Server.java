package rest.Deployment;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.people.User;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.SearchParameters;
import com.flickr4java.flickr.tags.ClusterList;
import com.flickr4java.flickr.tags.TagsInterface;
import com.flickr4java.flickr.test.TestInterface;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import rest.DAO.FlickrDao;

public class Server
{
    private static final URI BASE_URI = URI.create("http://localhost:8443/");

      public static void main(String[] args) throws Exception, IllegalArgumentException, IOException, URISyntaxException
    {
        System.out.println("Starting Flickr standalone HTTP server...");
        JdkHttpServerFactory.createHttpServer(BASE_URI, createApp());
        System.out.println("Server started on " + BASE_URI + "\n[kill the process to exit]");

        Flickr f = FlickrDao.instance.getFlickr();
        PhotosInterface photosInterface = f.getPhotosInterface();
        Photo photo = null;

        try {
            SearchParameters parameters = new SearchParameters();
            parameters.setTags(new String[]{"pizza","food"});
            parameters.setSort(SearchParameters.RELEVANCE);
            parameters.setText("pizza");

            PhotoList<Photo> list = photosInterface.search(parameters,30,1);

            Random rmd = new Random();
            int photo_index = rmd.nextInt(list.size());
            photo = list.get(photo_index);
        }
        catch (FlickrException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(photo.getUrl());


    }
    public static ResourceConfig createApp() {
        return new MyApplicationConfig();
    }
}
