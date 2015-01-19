package rest.DAO;

/**
 * Created by les on 01/11/14.
 */


import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import org.dozer.DozerBeanMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public enum FlickrDao {
    instance;
    private EntityManagerFactory emf;
    private String apiKey = "ba89157f14a6ae5a17772e71b94831f0";
    private String sharedSecret = "855b1947ced1b8d3";
    private Flickr flickr;

    private FlickrDao() {
       flickr = new Flickr(apiKey, sharedSecret, new REST());
    }


    public Flickr getFlickr() {
        return flickr;
    }


    // Person related operations could also directly go into the "Person" Model
    // Check Methods in LifeStaus as example

    // add other database global access operations

}

