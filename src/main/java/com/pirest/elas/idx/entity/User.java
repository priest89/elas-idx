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
 * The persistent class for the USER database table.
 * 
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

    public enum Status {
        DISABLED,
        ENABLED,
        DELETED,
        EXPIRED
    }

	@Id
	@Column(name = "user_id")
	private Long userId;

    @Column(name = "user_guid", length = 25, nullable = false)
    private String userGuid;

    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name = "default_region_id")
    private Region region;
    
   
    @Column(name = "user_name", length = 64)
    private String userName;

    @Column(length = 64)
    private String password;

    @Column(name = "change_login_password")
    boolean changeLoginPassword;
    
	@Column(name = "first_name", length = 255)
	private String firstName;

	@Column(name = "last_name", length = 255)
	private String lastName;

    @Column(length = 255)
    private String email;

    @Column(length = 25)
    private String phone;
    
    @Column(name = "image_url", length = 2048)
    private String imageUrl;

    @Column(name = "status", length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.DISABLED;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="expiration_date")
    private Date expirationDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;


    /**************************************************************
     To-Many relationships
     **************************************************************/
    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Device> devices = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, orphanRemoval = true)
	private List<UserToken> userTokens = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<ChannelToUser> channelToUsers = new ArrayList<>();
    
    @OneToMany(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "user_id", nullable = false)
    private List<UserToImageSize> userImageSizes = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "user_to_role",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    private List<Role> roles = new ArrayList<>();

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

    public User() {
        this.devices = new LinkedList<>();
        this.userTokens = new ArrayList<>();
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isChangeLoginPassword() {
		return changeLoginPassword;
	}

	public void setChangeLoginPassword(boolean changeLoginPassword) {
		this.changeLoginPassword = changeLoginPassword;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getUserGuid() {
		return this.userGuid;
	}

	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

    /**************************************************************
     To-Many relationships
     **************************************************************/
    public List<Device> getDevices() {
        return this.devices;
    }

    public void setDevices(List<Device> devices) {
        if (devices == null) {
            getDevices().clear();
        } else {
            this.devices = devices;
            for (Device device : devices) {
                device.setUser(this);
            }
        }
    }

    public boolean addDevice(Device device) {
        if (device != null && getDevices().add(device)) {
            device.setUser(this);
            return true;
        }
        return false;
    }

    public boolean removeDevice(Device device) {
        if (device != null && getDevices().remove(device)) {
            device.setUser(null);
            return true;
        }
        return false;
    }

    public List<UserToken> getUserTokens() {
        return this.userTokens;
    }

    public void setUserTokens(List<UserToken> userTokens) {
        if (userTokens == null) {
            getUserTokens().clear();
        } else {
            this.userTokens = userTokens;
            for (UserToken token : userTokens) {
                token.setUser(this);
            }
        }
    }

	public boolean addUserToken(UserToken userToken) {
        if (userToken != null && getUserTokens().add(userToken)) {
            userToken.setUser(this);
            return true;
        }
        return false;
    }

	public boolean removeUserToken(UserToken userToken) {
        if (userToken != null && getUserTokens().remove(userToken)) {
            userToken.setUser(null);
            return true;
        }
        return false;
	}

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        if (roles == null) {
            getRoles().clear();
        } else {
            this.roles = roles;
        }
    }

    public boolean addRole(Role role) {
        return role != null && getRoles().add(role);
    }

    public boolean removeRole(Role role) {
        return role != null && getRoles().remove(role);
    }

    public List<ChannelToUser> getChannelToUsers() {
        return channelToUsers;
    }

    public void setChannelToUsers(List<ChannelToUser> channelToUsers) {
        this.channelToUsers = channelToUsers;
    }

    public List<Channel> getChannels() {
        List<Channel> channels = new ArrayList<>();
        if (getChannelToUsers() != null) {
            for (ChannelToUser channelToUser : getChannelToUsers()) {
                channels.add(channelToUser.getChannel());
            }
        }
        return channels;
    }

    public void addChannel(Channel channel, Integer order) {
        if (channel != null) {
            ChannelToUser channelToUser = new ChannelToUser();
            channelToUser.setUser(this);
            channelToUser.setChannel(channel);
            channelToUser.setTunerOrder(order);
            getChannelToUsers().add(channelToUser);
        }
    }
    
    public boolean removeChannel(Channel channel) {
    	if (channel != null) {
    		for (ChannelToUser channelToUser : getChannelToUsers())
    			if (channelToUser.getChannel().equals(channel)) {
    				getChannelToUsers().remove(channelToUser);
    				return true;
    			}
    	}
    	
    	return false;
    }

    public List<UserToImageSize> getUserImageSizes() {
		return userImageSizes;
	}

	public void setUserImageSizes(List<UserToImageSize> userImageSizes) {
		this.userImageSizes = userImageSizes;
	}

    //convenience methods to get images urls
    public List<String> getImageUrls(String imageHostName){
    	return getImageUrls(imageHostName, true);
    }
    public List<String> getImageUrls(String imageHostName, boolean includeUpscaledImages){
    	List<String> imageUrls = new ArrayList<>();
    	for(UserToImageSize userImageSize : userImageSizes) {
    		if (userImageSize.isUpScaled() && ! includeUpscaledImages) {
    			continue;
    		}
    		imageUrls.add(encodeImageUrl(imageHostName,userImageSize.getImageSize()));
    	}
    	return imageUrls;
    }
    
    public String getImageUrlHighestResolution(String imageHostName) {
    	return getImageUrlHighestResolution(imageHostName,true);
    }
    public String getImageUrlHighestResolution(String imageHostName, boolean includeUpscaledImages) {
    	
    	UserImageSize largestImage = null;
    	long highestResolution = 0;
    	for(UserToImageSize userImageSize : userImageSizes) {
    		if (userImageSize.isUpScaled() && ! includeUpscaledImages) {
    			continue;
    		}
    		UserImageSize imageSize = userImageSize.getImageSize();
    		long resolution = imageSize.getHeight() * imageSize.getWidth();
    		if (resolution > highestResolution) {
    			highestResolution = resolution;
    			largestImage = imageSize;
    		}
    	}
    	return largestImage != null ? encodeImageUrl(imageHostName, largestImage) : null;
    }
    
    public String getUserImageUrl(String imageHostName, UserImageSize imageSize) {
    	for(UserToImageSize userToImage : userImageSizes) {
    		if(userToImage.getImageSizeId() == imageSize.getImageSizeId())
    			return encodeImageUrl(imageHostName, userToImage.getImageSize());
    	}
    	return null;
    }
    
    public String getOriginalUserImageUrl(String imageHostName) {
    	if(this.getUserImageSizes() != null && this.getUserImageSizes().size() > 0)
    		return encodeImageUrl(imageHostName, null);
    	else
    		return null;
    }
    
    private static final String SOLID = "solid";
   	private static final String RECTANGLE = "rectangle";

    private String encodeImageUrl(String imageHostName, UserImageSize imageSize) {
       	// image type = solid and shape = rectangle are stored differently on S3 bucket
    	if(imageSize ==  null)
    		return imageHostName+"/user/"+userGuid+"/original/"+userGuid+".jpg";
    	else if(imageSize.getType().equalsIgnoreCase(SOLID) && imageSize.getShape().equalsIgnoreCase(RECTANGLE))
    		return imageHostName+"/user/"+userGuid+"/w"+imageSize.getWidth()+"_h"+imageSize.getHeight()+"/"+userGuid+"."+imageSize.getExtension();
       	else
       		return imageHostName+"/user/"+userGuid+"/"+imageSize.getType()+"/"+imageSize.getShape()+"/w"+imageSize.getWidth()+"_h"+imageSize.getHeight()+"/"+userGuid+"."+imageSize.getExtension();
    }
	
    public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}