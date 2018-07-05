package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the DEVICE database table.
 * 
 */
@Entity
@Table(name = "device") 
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "device_id")
	private long deviceId;

    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "device_access_token", length = 45)
    private String deviceAccessToken;

    @Column(name = "device_notification_token", length = 45)
    private String deviceNotificationToken;

    @Column(length = 128)
    private String os;

    @Column(name = "os_version")
    private String osVersion;

    @Column(length = 128)
	private String model;

    @Column(length = 128)
    private String manufacturer;

	@Column(name = "screen_height")
	private int screenHeight;

	@Column(name = "screen_width")
	private int screenWidth;

    @Column(name = "app_version", length = 50)
    private String appVersion;

    //bi-directional many-to-one association to App
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name="app_id")
    private App app;
    
    @Column(name = "user_agent", length=256)
    private String userAgent;
    
    @Column(name = "country", length=4)
    private String country;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;

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

	public Device() {
	}

	public long getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public String getAppVersion() {
		return this.appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDeviceAccessToken() {
		return this.deviceAccessToken;
	}

	public void setDeviceAccessToken(String deviceAccessToken) {
		this.deviceAccessToken = deviceAccessToken;
	}

	public String getDeviceNotificationToken() {
		return this.deviceNotificationToken;
	}

	public void setDeviceNotificationToken(String deviceNotificationToken) {
		this.deviceNotificationToken = deviceNotificationToken;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsVersion() {
		return this.osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public int getScreenHeight() {
		return this.screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public int getScreenWidth() {
		return this.screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
        this.user = user;
        if (user != null && !user.getDevices().contains(this)) {
            user.addDevice(this);
        }
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}