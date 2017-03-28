package edu.csusb.rsstutorial;

import java.net.URL;

/**
 * Created by JayRyu on 3/28/17.
 */

public class FeedItem {
    private String title;
    private String description;
    private String link;
    private String pubDate;
    private String thumbnailURL;

    public FeedItem() {}

    public FeedItem(String title, String description, String link, String pubDate, String thumbnailURL) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.pubDate = pubDate;
        this.thumbnailURL = thumbnailURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }
}
