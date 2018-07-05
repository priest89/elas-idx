package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the FEED_ORIGIN database table.
 * 
 */
@Entity
@Table(name = "feed_origin")
public class FeedOrigin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "feed_origin_id")
	private long feedOriginId;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(name = "logo_url", length = 1024)
    private String logoUrl;

	@Column(length = 255)
	private String description;

    @Column(length = 12)
	private String version;

    //bi-directional many-to-one association to FeedQuality
    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "feed_quality_id", nullable = false)
    private FeedQuality feedQuality;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;

	//bi-directional many-to-one association to Feed
	@OneToMany(mappedBy = "feedOrigin", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Feed> feeds;

	//bi-directional many-to-one association to Video
	@OneToMany(mappedBy = "feedOrigin", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Video> videos;

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        createDate = date;
        lastmodified = date;
    }

    @PreUpdate
    protected void onUpdate() {
        lastmodified = new Date();
    }

    public FeedOrigin() {
	}

	public long getFeedOriginId() {
		return this.feedOriginId;
	}

	public void setFeedOriginId(long feedOriginId) {
		this.feedOriginId = feedOriginId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public String getLogoUrl() {
		return this.logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Feed> getFeeds() {
		return this.feeds;
	}

	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}

	public Feed addFeed(Feed feed) {
		getFeeds().add(feed);
		feed.setFeedOrigin(this);

		return feed;
	}

	public Feed removeFeed(Feed feed) {
		getFeeds().remove(feed);
		feed.setFeedOrigin(null);

		return feed;
	}

	public FeedQuality getFeedQuality() {
		return this.feedQuality;
	}

	public void setFeedQuality(FeedQuality feedQuality) {
		this.feedQuality = feedQuality;
	}

	public List<Video> getVideos() {
		return this.videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Video addVideo(Video video) {
		getVideos().add(video);
		video.setFeedOrigin(this);

		return video;
	}

	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setFeedOrigin(null);

		return video;
	}

}