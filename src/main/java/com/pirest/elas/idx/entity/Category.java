package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

import org.springframework.util.CollectionUtils;


/**
 * The persistent class for the CATEGORY database table.
 * 
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

    public enum Status {
        DISABLED,
        ENABLED,
        PREVIEW
    }

	@Id
	@Column(name = "category_id")
	private long categoryId;

	@Column(name = "category_guid", length = 25)
	private String categoryGuid;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(length = 255)
	private String title;

    @Column(name = "image_url", length = 2048)
    private String imageUrl;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "app_id", nullable = false)
    private App app;

    @Column(name = "status", length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ENABLED;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;


	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy = "parent", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Category> children = new ArrayList<>();

    // ClusterJ throws error with message "unsupported field type java.util.List for field channel"
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "category_to_channel",
            joinColumns = {
                    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "channel_id", referencedColumnName = "channel_id")
            })
    private Collection<Channel> channels = new ArrayList<>();

    
	//many to one association with category_image_size table. CategoryToImageSize object contains association to image_isze table
	//where the resolution of the image can interrogated
	@OneToMany(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "category_id", nullable = false)
    private List<CategoryToImageSize> categoryImageSizes = new ArrayList<>();
    
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

	public Category() {
	}

    public long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryGuid() {
		return this.categoryGuid;
	}

	public void setCategoryGuid(String categoryGuid) {
		this.categoryGuid = categoryGuid;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public App getApp() {
		return this.app;
	}

	public void setApp(App app) {
		this.app = app;
	}

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Region getRegion() {
        return this.region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Category getParent() {
        return this.parent;
    }

    public void setParent(Category parent) {
		if (parent != null && !parent.getChildren().contains(this)) {
            parent.getChildren().add(this);
        }
        this.parent = parent;
	}

    public boolean containsChildren(Category category) {
    	if(CollectionUtils.isEmpty(this.getChildren()))
    		return false;
    	else 
    		return this.getChildren().contains(category);
    }
    
    public boolean hasChildren() {
    	if(CollectionUtils.isEmpty(this.getChildren()))
    		return false;
    	else 
    		return true;
    }
    
	public List<Category> getChildren() {
		return this.children;
	}

	public boolean addChild(Category category) {
        if (category == null) {
            return false;
        }
		category.setParent(this);
        return getChildren().add(category);
	}

	public boolean removeChild(Category category) {
        if (category == null) {
            return false;
        }
		category.setParent(null);
        return getChildren().remove(category);
	}

	public boolean hasChannels() {
		if(CollectionUtils.isEmpty(this.getChannels()))
			return false;
		else
			return true;
	}
	
	public boolean containsChannel(Channel channel) {
		if(CollectionUtils.isEmpty(this.getChannels()))
			return false;
		else
			return this.getChannels().contains(channel);
	}
	
    public Collection<Channel> getChannels() {
        return this.channels;
    }

    public boolean addChannel(Channel channel) {
        if (channel != null && getChannels().add(channel)) {
            if (!channel.getCategories().contains(this)) {
                channel.addCategory(this);
            }
            return true;
        }
        return false;
    }

    public boolean removeChannel(Channel channel) {
        if (channel != null && getChannels().remove(channel)) {
            channel.removeCategory(this);
            return true;
        }
        return false;
    }
    
    public static Long getCategoryIdFromComboId(String combo) {
		String categoryId = null;
		if(combo.contains("5-"))
			categoryId = combo.substring(2, combo.length());
		else
			categoryId = combo;
		
		if(categoryId.matches("\\D"))
		//if(!Long.class.isInstance(categoryId) || !Integer.class.isInstance(categoryId))
			throw new IllegalArgumentException("Invalid category_id: " + combo);
		return Long.valueOf(categoryId);
	}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

	public List<CategoryToImageSize> getCategoryImageSizes() {
		return categoryImageSizes;
	}

	public void setCategoryImageSizes(List<CategoryToImageSize> categoryImageSizes) {
		this.categoryImageSizes = categoryImageSizes;
	}
    //convenience methods to get images urls
    public List<String> getImageUrls(String imageHostName){
    	return getImageUrls(imageHostName, true);
    }
    public List<String> getImageUrls(String imageHostName, boolean includeUpscaledImages){
    	List<String> imageUrls = new ArrayList<>();
    	for(CategoryToImageSize categoryImageSize : categoryImageSizes) {
    		if (categoryImageSize.isUpScaled() && ! includeUpscaledImages) {
    			continue;
    		}
    		imageUrls.add(encodeImageUrl(imageHostName, categoryImageSize.getImageSize()));
    	}
    	return imageUrls;
    }
    
    public String getImageUrlHighestResolution(String imageHostName) {
    	return getImageUrlHighestResolution(imageHostName,true);
    }
    public String getImageUrlHighestResolution(String imageHostName,boolean includeUpscaledImages) {
    	
    	CategoryImageSize largestImage = null;
    	long highestResolution = 0;
    	for(CategoryToImageSize categoryImageSize : categoryImageSizes) {
    		if (categoryImageSize.isUpScaled() && ! includeUpscaledImages) {
    			continue;
    		}
    		CategoryImageSize imageSize = categoryImageSize.getImageSize();
    		long resolution = imageSize.getHeight() * imageSize.getWidth();
    		if (resolution > highestResolution) {
    			highestResolution = resolution;
    			largestImage = imageSize;
    		}
    	}
    	return largestImage != null ? encodeImageUrl(imageHostName,largestImage) : null;
    }
    
    public String getCategoryImageUrl(String imageHostName, CategoryImageSize imageSize) {
    	for(CategoryToImageSize categoryToImage : categoryImageSizes) {
    		if(categoryToImage.getImageSizeId() == imageSize.getImageSizeId())
    			return encodeImageUrl(imageHostName, categoryToImage.getImageSize());
    	}
    	return null;
    }
    
    public String getOriginalCategoryImageUrl(String imageHostName) {
    	if(this.getCategoryImageSizes() != null && this.getCategoryImageSizes().size() > 0)
    		return encodeImageUrl(imageHostName, null);
    	else
    		return null;
    }
    
    private static final String SOLID = "solid";
	private static final String RECTANGLE = "rectangle";

    private String encodeImageUrl(String imageHostName, CategoryImageSize imageSize) {
    	// image type = solid and shape = rectangle are stored differently on S3 bucket
    	if(imageSize == null) 
    		return imageHostName+"/category/"+categoryGuid+"/original/"+categoryGuid+".jpg";
    	else if(imageSize.getType().equalsIgnoreCase(SOLID) && imageSize.getShape().equalsIgnoreCase(RECTANGLE))
    		return imageHostName+"/category/"+categoryGuid+"/w"+imageSize.getWidth()+"_h"+imageSize.getHeight()+"/"+categoryGuid+"."+imageSize.getExtension();
    	else
    		return imageHostName+"/category/"+categoryGuid+"/"+imageSize.getType()+"/"+imageSize.getShape()+"/w"+imageSize.getWidth()+"_h"+imageSize.getHeight()+"/"+categoryGuid+"."+imageSize.getExtension();
    }
}