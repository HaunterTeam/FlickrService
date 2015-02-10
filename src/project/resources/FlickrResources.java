package project.resources;

/**
 * Created by les on 28/12/14.
 */

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.SearchParameters;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import project.beans.PhotoBean;
import project.dao.FlickrDao;

@Path("/flickr")
public class FlickrResources {

    static final short  items_per_page = 10;
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Path("{food}")
    @Produces(MediaType.APPLICATION_JSON )
    public PhotoBean getFoodPictureFromTag(@PathParam("food") String food) {

        Flickr f = FlickrDao.instance.getFlickr();
        PhotosInterface photosInterface = f.getPhotosInterface();
        Photo photo = null;
        Boolean visited[] = new Boolean[items_per_page];
        Arrays.fill(visited,false);

        try {
            SearchParameters parameters = new SearchParameters();
            parameters.setTags(new String[]{food,"food"});
            parameters.setSort(SearchParameters.RELEVANCE);
            parameters.setText(food);

            PhotoList<Photo> list = photosInterface.search(parameters,items_per_page,1);

            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getTitle()+" "+list.get(i).getLargeUrl()+"\n");
            }

            Random rmd = new Random();
            int count = 0;
            do {
                int photo_index = rmd.nextInt(list.size());
                if(visited[photo_index])
                    continue;
                photo = list.get(photo_index);
                count++; //Ths will prevent an infinite loop if there are no valid images.
            }
            while ((photo.getLargeUrl() == null || photo.getLargeUrl().equals(""))  && count < 100); //There must be at least one element with a valid url, I hope!
        }
        catch (FlickrException ex){
            System.out.println(ex.getMessage());
        }

        return PhotoBean.createBeanFromPhoto(photo);

    }
}