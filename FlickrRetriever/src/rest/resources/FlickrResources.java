package rest.resources;

/**
 * Created by les on 28/12/14.
 */

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.tags.TagsInterface;
import rest.Beans.PhotoBean;
import rest.DAO.FlickrDao;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/flickr")
public class FlickrResources {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Path("{food}")
    @Produces(MediaType.APPLICATION_JSON )
    public PhotoBean getFoodPictureFromTag(@PathParam("food") String food){

        Flickr f = FlickrDao.instance.getFlickr();
        TagsInterface tagsInterface = f.getTagsInterface();
        Photo photo = null;

        try {
            PhotoList<Photo> list = tagsInterface.getClusterPhotos(food, "1");

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
