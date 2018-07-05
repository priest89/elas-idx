package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * The persistent class for the VIDEO database table.
 * 
 */
@Entity
@Table(name = "video")
public class Video implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
	@Column(name = "video_id")
	private Long videoId;

    @Column(name = "video_guid")
    private String videoGuid;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id")
    private ContentPartner contentPartner;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "parental_rating_id")
    private ParentalRating parentalRating;

    private String title;

    @Column(name = "description_long")
    private String descriptionLong;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "video_source_id", unique = true)
    private String videoSourceId;
    
//    @Column(name = "web_link")
//    private String webLink;
//
//    private String deeplink;

    @Column(name = "referrer_link")
    private String referrerLink;

    //bi-directional many-to-one association to Source
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Source source;

    @Column(name = "tms_id")
    private String tmsId;
    
    @Column(name = "cuepoints")
    private String cuePoints;
    
    private Integer duration;

    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "feed_origin_id")
    private FeedOrigin feedOrigin;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiration_date", columnDefinition = "DATETIME", nullable = true, updatable = true)
    private Date expirationDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "published_date", columnDefinition = "DATETIME", nullable = true, updatable = true)
    private Date publishedDate;
    
    @Column(name = "status")
    private String status;
    
	public String getCuePoints() {
		return cuePoints;
	}

	public void setCuePoints(String cuePoints) {
		this.cuePoints = cuePoints;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/*
 * Below are fields related indirectly by a column from a different table
 */
	//bi-directional many-to-one association to Blacklist
	@OneToMany(mappedBy = "video", cascade = {CascadeType.REFRESH})
	private List<Blacklist> blacklists = new ArrayList<>();

	@OneToMany(mappedBy = "video", cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
	private List<ChannelToVideo> channelToVideos = new ArrayList<>();
	
	//bi-directional many-to-many association to Keyword
	@ManyToMany(cascade = {CascadeType.REFRESH})
	@JoinTable(
            name = "video_to_keyword",
            joinColumns = {
                    @JoinColumn(name = "video_id")
			},
            inverseJoinColumns = {
                    @JoinColumn(name = "keyword_id")
			},
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = {
                            "keyword_id", "video_id"
                    })
            }
		)
	private List<Keyword> keywords = new ArrayList<>();

	//bi-directional many-to-one association to VideoMedia
	@OneToMany(mappedBy = "video", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<VideoMedia> videoMedias = new ArrayList<>();

	//many to one association with video_image_size table. VideoToImage object contains association to image_isze table
	//where the resolution of the image can interrogated
	@OneToMany(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "video_id", nullable = false)
    private List<VideoToImageSize> videoImageSizes = new ArrayList<>();
	
    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        createdate = date;
        lastmodified = date;
    }

    @PreUpdate
    protected void onUpdate() {
        lastmodified = new Date();
    }

    

    public Video() {

//        this.blacklists = new LinkedList<>();
//        this.videoMedias = new LinkedList<>();
	}

	public Long getVideoId() {
		return this.videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public String getDescriptionLong() {
		return this.descriptionLong;
	}

	public void setDescriptionLong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

    public String getReferrerLink() {
		return this.referrerLink;
	}

	public void setReferrerLink(String referrerLink) {
		this.referrerLink = referrerLink;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTmsId() {
		return this.tmsId;
	}

	public void setTmsId(String tmsId) {
		this.tmsId = tmsId;
	}

	public String getVideoGuid() {
		return this.videoGuid;
	}

	public void setVideoGuid(String videoGuid) {
		this.videoGuid = videoGuid;
	}

	public List<Blacklist> getBlacklists() {
		return this.blacklists;
	}

	public void setBlacklists(List<Blacklist> blacklists) {
        if (blacklists != null) {
            for (Blacklist blacklist : blacklists) {
                blacklist.setVideo(this);
            }
        }
      
        this.blacklists = blacklists;
	}

	public boolean addBlacklist(Blacklist blacklist) {
        if (blacklist == null) {
            return false;
        }
        blacklist.setVideo(this);
        return this.blacklists.add(blacklist);
	}

	public boolean removeBlacklist(Blacklist blacklist) {
        if (blacklist == null) {
            return false;
        }

        if (this.blacklists == null) {
            return false;
        }

        blacklist.setVideo(null);
        return this.blacklists.remove(blacklist);
	}

	public List<Channel> getChannels() {
		List<Channel> channels = new ArrayList<>();
		
		if (getChannelToVideos() != null) {
			for (ChannelToVideo channelToVideo : getChannelToVideos()) {
			    if (channelToVideo.getChannel() != null)
			        channels.add(channelToVideo.getChannel());
			}
		}
		
		return channels;
	}

    public boolean addChannel(Channel channel) {
    	if (channel == null)
    		return false;
    	
    	for (ChannelToVideo existing : getChannelToVideos())
    		if (existing.getChannel().equals(channel))
    			return false;
    	
		ChannelToVideo newChannelToVideo = new ChannelToVideo();
		newChannelToVideo.setChannel(channel);
		newChannelToVideo.setVideo(this);
		getChannelToVideos().add(newChannelToVideo);
		
		// newChannel.setCreateDate(new Date()); //set current time by default TODO
		// newChannel.setLastModified(new Date());
		return true;
    }

    public boolean removeChannel(Channel channel) {
    	if (channel == null)
    		return false;
    	
    	ChannelToVideo remove = null;
    	for (ChannelToVideo existing : getChannelToVideos())
    		if (existing.getChannel().equals(channel)) {
    			remove = existing;
    			break;
    		}
    	
    	if (remove != null) {
    		getChannelToVideos().remove(remove);
    		return true;
    	}
    	
    	return false;
    }

	public List<ChannelToVideo> getChannelToVideos() {
		return channelToVideos;
	}

	public void setChannelToVideos(List<ChannelToVideo> channelToVideos) {
		this.channelToVideos = channelToVideos;
	}

	public ContentPartner getContentPartner() {
		return this.contentPartner;
	}

	public void setContentPartner(ContentPartner contentPartner) {
		this.contentPartner = contentPartner;
	}

	public FeedOrigin getFeedOrigin() {
		return this.feedOrigin;
	}

	public void setFeedOrigin(FeedOrigin feedOrigin) {
		this.feedOrigin = feedOrigin;
	}

	public List<Keyword> getKeywords() {
		return this.keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}

	public ParentalRating getParentalRating() {
		return this.parentalRating;
	}

	public void setParentalRating(ParentalRating parentalRating) {
		this.parentalRating = parentalRating;
	}

	public Source getSource() {
		return this.source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public List<VideoMedia> getVideoMedias() {
		return this.videoMedias;
	}

	public void setVideoMedias(List<VideoMedia> videoMedias) {
		if (videoMedias != null) {
            for (VideoMedia videoMedia : videoMedias) {
                videoMedia.setVideo(this);
            }
        }
        this.videoMedias = videoMedias;
	}

	public boolean addVideoMedia(VideoMedia videoMedia) {
        if (videoMedia == null) {
            return false;
        }

        if (this.videoMedias == null) {
            this.videoMedias = new LinkedList<>();
        }

        videoMedia.setVideo(this);
        return this.videoMedias.add(videoMedia);
	}

	public boolean removeVideoMedia(VideoMedia videoMedia) {
        if (videoMedia == null) {
            return false;
        }

        if (this.videoMedias == null) {
            return false;
        }

		videoMedia.setVideo(null);
        return this.videoMedias.remove(videoMedia);
	}

    public List<VideoToImageSize> getVideoImageSizes() {
		return videoImageSizes;
	}

	public void setVideoImageSizes(List<VideoToImageSize> videoImageSizes) {
		this.videoImageSizes = videoImageSizes;
	}
	
    public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    //convenience methods to get images urls
    public List<String> getImageUrls(String imageHostName){
    	return getImageUrls(imageHostName, true);
    }
    public List<String> getImageUrls(String imageHostName, boolean includeUpscaledImages){
    	List<String> imageUrls = new ArrayList<>();
    	for(VideoToImageSize videoImageSize : videoImageSizes) {
    		if (videoImageSize.isUpScaled() && ! includeUpscaledImages) {
    			continue;
    		}
    		imageUrls.add(encodeImageUrl(imageHostName, videoImageSize.getImageSize()));
    	}
    	return imageUrls;
    }
    
    public String getImageUrlHighestResolution(String imageHostName) {
    	return getImageUrlHighestResolution(imageHostName, true);
    }
    public String getImageUrlHighestResolution(String imageHostName, boolean includeUpscaledImages) {
    	
    	VideoImageSize largestImage = null;
    	long highestResolution = 0;
    	for(VideoToImageSize videoImageSize : videoImageSizes) {
    		if (videoImageSize.isUpScaled() && ! includeUpscaledImages) {
    			continue;
    		}
    		VideoImageSize imageSize = videoImageSize.getImageSize();
    		long resolution = imageSize.getHeight() * imageSize.getWidth();
    		if (resolution > highestResolution) {
    			highestResolution = resolution;
    			largestImage = imageSize;
    		}
    	}
    	return largestImage != null ? encodeImageUrl(imageHostName, largestImage) : null;
    }
    
    public String getVideoImageUrl(String imageHostName, VideoImageSize imageSize) {
    	for(VideoToImageSize videoToImage : videoImageSizes) {
    		if(videoToImage.getImageSizeId() == imageSize.getImageSizeId())
    			return encodeImageUrl(imageHostName, videoToImage.getImageSize()); 		
    	}
    	return null;
    }
    
    public String getOriginalVideoImageUrl(String imageHostName) {
    	if(this.getVideoImageSizes() != null && this.getVideoImageSizes().size() > 0)
    		return encodeImageUrl(imageHostName, null);
    	else
    		return null;
    }
    
    private static final String SOLID = "solid";
   	private static final String RECTANGLE = "rectangle";

    private String encodeImageUrl(String imageHostName, VideoImageSize imageSize) {
       	// image type = solid and shape = rectangle are stored differently on S3 bucket
    	if(imageSize == null)
    		return imageHostName+"/video/"+videoGuid+"/original/"+videoGuid+".jpg";
    	else if(imageSize.getType().equalsIgnoreCase(SOLID) && imageSize.getShape().equalsIgnoreCase(RECTANGLE))
    	   	return imageHostName+"/video/"+videoGuid+"/w"+imageSize.getWidth()+"_h"+imageSize.getHeight()+"/"+videoGuid+"."+imageSize.getExtension();
       	else
       		return imageHostName+"/video/"+videoGuid+"/"+imageSize.getType()+"/"+imageSize.getShape()+"/w"+imageSize.getWidth()+"_h"+imageSize.getHeight()+"/"+videoGuid+"."+imageSize.getExtension();
    }
          
    public String getVideoSourceId() {
		return videoSourceId;
	}

	public void setVideoSourceId(String videoSourceId) {
		this.videoSourceId = videoSourceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}