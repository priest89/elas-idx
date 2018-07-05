package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

/**
 * The persistent class for the CHANNEL database table.
 * 
 */
@Entity
@Table(name = "channel")
public class Channel implements Serializable {
	private static final long serialVersionUID = 1L;

    public enum Status {
        DISABLED,
        ENABLED,
        PREVIEW
    }

	@Id
	@Column(name = "channel_id")
	private long channelId;

    @Column(name = "channel_guid", length = 25)
    private String channelGuid;

    //bi-directional many-to-one association to Network
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name = "network_id")
	private Network network;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Column(name = "tms_id", length = 24)
    private String tmsId;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name = "region_id")
	private Region region;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name = "language_id")
	private Language language;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name = "parental_rating_id")
	private ParentalRating parentalRating;

    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "channel_type_id", nullable = false)
    private ChannelType channelType;

    @Column(name = "channel_type_data", length = 255)
	private String channelTypeData;

    @Column(length = 255)
    private String title;

    @Column(name = "title_short", length = 255)
    private String titleShort;

    @Column(name = "title_shorter", length = 255)
    private String titleShorter;

	@Column(length = 2048)
	private String description;

    @Column(name = "image_url", length = 2048)
    private String imageUrl;

    @Column(name = "update_frequency", columnDefinition = "INT")
    private Integer updateFrequency = 3600;

    private Integer popularity = 0;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean recommended = false;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean addable = true;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean reorderable = true;

	@Column(name = "frequency_sync", columnDefinition = "TINYINT(1)")
	private Boolean frequencySync = false;

    @Column(name = "status", length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.DISABLED;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date lastmodified;


//////////////////////////////////////////////////////////////////////////
//  M2M relationships that don't quite work well with ClusterJ
//////////////////////////////////////////////////////////////////////////
//

	@ManyToMany(mappedBy = "channels", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Category> categories = new ArrayList<>();


	//bi-directional many-to-many association to Channel
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})

	@JoinTable(
		name="channel_to_channel"
		, joinColumns={
			@JoinColumn(name = "channel_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name = "channel_parent_id")
			}
		)


	private List<Channel> parents;

	//bi-directional many-to-many association to Channel
	@ManyToMany(mappedBy = "parents", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Channel> children;

    @OneToMany(mappedBy = "channel")
    private List<ChannelToUser> channelToUsers = new ArrayList<>();
    
    @OneToMany(mappedBy = "channel")
    private List<ChannelToSubGenre> channelToSubGenres = new ArrayList<>();

	@OneToMany(mappedBy = "channel", cascade = { CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<DefaultAppChannels> defaultAppChannels;

	@OneToMany(mappedBy = "channel", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ChannelToApp> channelToAppList = new LinkedList<>();
	
	//many to one association with channel_image_size table. ChannelToImageSize object contains association to image_isze table
	//where the resolution of the image can interrogated
	@OneToMany(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "channel_id", nullable = false)
    private List<ChannelToImageSize> channelImageSizes = new ArrayList<>();

	//////////////////////////////////////////////////////////////////////////
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

	public Channel() {
	}

    public List<Category> getCategories() {
        return categories;
    }

    public boolean addCategory(Category category) {
        if (category != null && getCategories().add(category)) {
            if (!category.getChannels().contains(this)) {
                category.addChannel(this);
            }
            return true;
        }
        return false;
    }

    public List<DefaultAppChannels> getDefaultAppChannels() {
		return defaultAppChannels;
	}

	public void setDefaultAppChannels(List<DefaultAppChannels> defaultAppChannels) {
		this.defaultAppChannels = defaultAppChannels;
	}
    
    public boolean removeCategory(Category category) {
        if (category != null && category.removeChannel(this)) {
            category.removeChannel(this);
            return true;
        }
        return false;
    }

    public List<Channel> getParents() {
        return parents;
    }

    public void setParents(List<Channel> parents) {
        this.parents = parents;
    }

    public List<Channel> getChildren() {
        return children;
    }

    public void setChildren(List<Channel> children) {
        this.children = children;
    }

    public boolean hasChildren() {
    	if(this.getChildren() != null && this.getChildren().size() > 0)
    		return true;
    	return false;
    }
    
    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public String getChannelGuid() {
        return channelGuid;
    }

    public void setChannelGuid(String channelGuid) {
        this.channelGuid = channelGuid;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public String getTmsId() {
        return tmsId;
    }

    public void setTmsId(String tmsId) {
        this.tmsId = tmsId;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public ParentalRating getParentalRating() {
        return parentalRating;
    }

    public void setParentalRating(ParentalRating parentalRating) {
        this.parentalRating = parentalRating;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public String getChannelTypeData() {
        return channelTypeData;
    }

    public void setChannelTypeData(String channelTypeData) {
        this.channelTypeData = channelTypeData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleShort() {
        return titleShort;
    }

    public void setTitleShort(String titleShort) {
        this.titleShort = titleShort;
    }

    public String getTitleShorter() {
        return titleShorter;
    }

    public void setTitleShorter(String titleShorter) {
        this.titleShorter = titleShorter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getUpdateFrequency() {
        return updateFrequency;
    }

    public void setUpdateFrequency(Integer updateFrequency) {
        this.updateFrequency = updateFrequency;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public boolean isAddable() {
        return addable;
    }

    public void setAddable(boolean addable) {
        this.addable = addable;
    }

    public boolean isReorderable() {
        return reorderable;
    }

    public void setReorderable(boolean reorderable) {
        this.reorderable = reorderable;
    }

    public boolean isFrequencySync() {
        return frequencySync;
    }

    public void setFrequencySync(boolean frequencySync) {
        this.frequencySync = frequencySync;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

	public List<ChannelToSubGenre> getChannelToSubGenres() {
		return channelToSubGenres;
	}

	public void setChannelToSubGenres(List<ChannelToSubGenre> channelToSubGenres) {
		this.channelToSubGenres = channelToSubGenres;
	}

	public List<ChannelToUser> getChannelToUsers() {
        return channelToUsers;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        if (getChannelToUsers() != null) {
            for (ChannelToUser channelToUser : getChannelToUsers()) {
                users.add(channelToUser.getUser());
            }
        }
        return users;
    }

    public static Long getChannelIdFromComboId(String combo) {
		String channelId = null;
		if(combo.contains("4-"))
			channelId = combo.substring(2, combo.length());
		else
			channelId = combo;
		
		if(channelId.matches("\\D"))
			throw new IllegalArgumentException("Invalid channel_id: " + combo);
		return Long.valueOf(channelId);
	}
    
    //@Override
    public List<ChannelToImageSize> getChannelImageSizes() {
		return channelImageSizes;
	}

	public void setChannelImageSizes(List<ChannelToImageSize> channelImageSizes) {
		this.channelImageSizes = channelImageSizes;
	}
	
    public List<ChannelToApp> getChannelToAppList() {
        return channelToAppList;
    }

    public void setChannelToAppList(List<ChannelToApp> channelToAppList) {
        this.channelToAppList = channelToAppList;
    }

    //convenience methods to get images urls
    public List<String> getImageUrls(String imageHostName){
    	return getImageUrls(imageHostName, true);
    }
    public List<String> getImageUrls(String imageHostName, boolean includeUpscaledImages){
    	List<String> imageUrls = new ArrayList<>();
    	for(ChannelToImageSize channelImageSize : channelImageSizes) {
    		if (channelImageSize.isUpScaled() && ! includeUpscaledImages) {
    			continue;
    		}
    		imageUrls.add(encodeImageUrl(imageHostName,channelImageSize.getImageSize()));
    	}
    	return imageUrls;
    }
    
    public String getImageUrlHighestResolution(String imageHostName) {
    	return getImageUrlHighestResolution(imageHostName,true);
    }
    public String getImageUrlHighestResolution(String imageHostName,boolean includeUpscaledImages) {
    	ChannelImageSize largestImage = null;
    	long highestResolution = 0;
    	for(ChannelToImageSize channelImageSize : channelImageSizes) {
    		if (channelImageSize.isUpScaled() && ! includeUpscaledImages) {
    			continue;
    		}
    		ChannelImageSize imageSize = channelImageSize.getImageSize();
    		long resolution = imageSize.getHeight() * imageSize.getWidth();
    		if (resolution > highestResolution) {
    			highestResolution = resolution;
    			largestImage = imageSize;
    		}
    	}
    	return largestImage != null ? encodeImageUrl(imageHostName,largestImage) : null;
    }
    
    public String getChannelImageUrl(String imageHostName, ChannelImageSize imageSize) {
    	for(ChannelToImageSize channelToImage : channelImageSizes) {
    		if(channelToImage.getImageSizeId() == imageSize.getImageSizeId())
    			return encodeImageUrl(imageHostName, channelToImage.getImageSize());
    	}
    	return null;
    }
    
    public String getOriginalChannelImageUrl(String imageHostName) {
    	if(this.getChannelImageSizes() != null && this.getChannelImageSizes().size() > 0)
    		return encodeImageUrl(imageHostName, null);
    	else
    		return null;
    }
    
    private static final String SOLID = "solid";
	private static final String RECTANGLE = "rectangle";

    private String encodeImageUrl(String imageHostName, ChannelImageSize imageSize) {
    	// image type = solid and shape = rectangle are stored differently on S3 bucket
    	if(imageSize == null)
    		return imageHostName+"/channel/"+channelGuid+"/original/"+channelGuid+".jpg";
    	else if(imageSize.getType().equalsIgnoreCase(SOLID) && imageSize.getShape().equalsIgnoreCase(RECTANGLE))
    		return imageHostName+"/channel/"+channelGuid+"/w"+imageSize.getWidth()+"_h"+imageSize.getHeight()+"/"+channelGuid+"."+imageSize.getExtension();
    	else
    		return imageHostName+"/channel/"+channelGuid+"/"+imageSize.getType()+"/"+imageSize.getShape()+"/w"+imageSize.getWidth()+"_h"+imageSize.getHeight()+"/"+channelGuid+"."+imageSize.getExtension();
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (channelId ^ (channelId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Channel other = (Channel) obj;
		if (channelId != other.channelId)
			return false;
		return true;
	}
}