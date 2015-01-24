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

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Path("{food}")
    @Produces(MediaType.APPLICATION_JSON )
    public PhotoBean getFoodPictureFromTag(@PathParam("food") String food) {
    	
    	System.err.println("Here");

        Flickr f = FlickrDao.instance.getFlickr();
        PhotosInterface photosInterface = f.getPhotosInterface();
        Photo photo = null;

        try {
            SearchParameters parameters = new SearchParameters();
            parameters.setTags(new String[]{food,"food"});
            parameters.setSort(SearchParameters.RELEVANCE);
            parameters.setText(food);

            PhotoList<Photo> list = photosInterface.search(parameters,30,1);

            Random rmd = new Random();
            int photo_index = rmd.nextInt(list.size());
            photo = list.get(photo_index);
        }
        catch (FlickrException ex){
            System.out.println(ex.getMessage());
        }

        return PhotoBean.createBeanFromPhoto(photo);

    }
}