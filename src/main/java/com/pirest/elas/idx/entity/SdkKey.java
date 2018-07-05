package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the SDK_KEY database table.
 * 
 */
@Entity
@Table(name = "sdk_key")
public class SdkKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "sdk_key_id")
	private long sdkKeyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date lastmodified;

	@Column(name = "sdk_key")
	private String sdkKey;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean enabled = false;

	//bi-directional many-to-one association to App
	@OneToMany(mappedBy = "sdkKey", cascade = {CascadeType.ALL})
	private List<App> apps;

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


    public SdkKey() {
        this.apps = new LinkedList<>();
	}

	public long getSdkKeyId() {
		return this.sdkKeyId;
	}

	public void setSdkKeyId(long sdkKeyId) {
		this.sdkKeyId = sdkKeyId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastmodified() {
		return this.lastmodified;
	}

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    public String getSdkKey() {
		return this.sdkKey;
	}

	public void setSdkKey(String sdkKey) {
		this.sdkKey = sdkKey;
	}

	public List<App> getApps() {
		return this.apps;
	}

	public void setApps(List<App> apps) {
        if (apps == null) {
            this.apps.clear();
        } else {
            for (App app : apps) {
                app.setSdkKey(this);
            }
            this.apps = apps;
        }
	}

	public boolean addApp(App app) {
        app.setSdkKey(this);
        return getApps().add(app);
	}

	public boolean removeApp(App app) {
        app.setSdkKey(null);
        return getApps().remove(app);
	}

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}