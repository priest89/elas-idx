package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * The persistent class for the APP database table.
 * 
 */
@Entity
@Table(name = "app")
public class App implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "app_id")
	private long appId;

	@Column(name = "app_name")
	private String appName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date lastmodified;

	//bi-directional many-to-one association to SdkKey
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "sdk_key_id")
	private SdkKey sdkKey;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy = "app", cascade = {CascadeType.ALL})
	private List<Category> categories;

	@OneToMany(mappedBy = "app")
    private List<DefaultAppChannels> defaultAppChannels = new ArrayList<>();
	
	public List<DefaultAppChannels> getDefaultAppChannels() {
		return defaultAppChannels;
	}

	public void setDefaultAppChannels(List<DefaultAppChannels> defaultAppChannels) {
		this.defaultAppChannels = defaultAppChannels;
	}

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

	public App() {
        this.categories = new ArrayList<>();
	}

	public long getAppId() {
		return this.appId;
	}

	public void setAppId(long appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public SdkKey getSdkKey() {
		return this.sdkKey;
	}

	public void setSdkKey(SdkKey sdkKey) {
		this.sdkKey = sdkKey;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
        if (categories == null) {
            this.categories.clear();
        } else {
            for (Category category : categories) {
                category.setApp(this);
            }
            this.categories = categories;
        }
	}

	public boolean addCategory(Category category) {
        category.setApp(this);
        return getCategories().add(category);
	}

	public boolean removeCategory(Category category) {
        category.setApp(null);
        return getCategories().remove(category);
	}

}