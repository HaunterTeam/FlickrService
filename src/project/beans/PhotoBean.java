package project.beans;

import com.flickr4java.flickr.photos.Photo;

import java.util.Date;

/**
 * Created by les on 28/12/14.
 */
public class PhotoBean {

    private String url;
    private String id;
    private Date dateAdded;
    private String description;
    private String title;

    public PhotoBean()
    {}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static PhotoBean createBeanFromPhoto(Photo photo){
        PhotoBean bean = new PhotoBean();

        bean.setDateAdded(photo.getDateAdded());
        bean.setDescription(photo.getDescription());
        bean.setId(photo.getId());
        bean.setTitle(photo.getTitle());
        bean.setUrl(photo.getUrl());

        return bean;
    }
}
