package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

    public enum Status {
        DISABLED,
        ENABLED,
        DELETED,
        EXPIRED
    }

	@Id
	@Column(name = "account_id")
	private long accountId;

	@Column(name = "account_guid", length = 25, nullable = false, updatable = false)
	private String accountGuid;

	@Column(length = 255)
	private String name;
	
	@Column(length = 255)
	private String description;
	
	@Column (name = "contact_name", length = 255)
	private String contactName;
	
	@Column(name = "contact_phone", length = 25)
	private String contactPhone;
	
	@Column(name = "contact_email", length = 255)
	private String contactEmail;
	
	@Column(name = "contact_website", length = 255)
	private String contactWebsite;
	
	@Column(name = "expiration_date")
	private Date expirationDate;
		
	
	@OneToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE}, optional = false)
	@JoinColumn(name = "sdk_key_id", nullable = false, unique = true)
	private SdkKey sdkKey;

	@OneToMany(mappedBy = "account", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
	private List<Blacklist> blacklists;

	@OneToMany(mappedBy = "account", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
	private List<User> users;

    @Column(name = "status", length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.DISABLED;
	
    @Column(name = "ttl_token_access")
    private Integer ttlTokenAccess;
    
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

	public Account() {
        this.blacklists = new ArrayList<>();
        this.users = new ArrayList<>();
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountGuid() {
		return this.accountGuid;
	}

	public void setAccountGuid(String accountGuid) {
		this.accountGuid = accountGuid;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SdkKey getSdkKey() {
		return this.sdkKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactWebsite() {
		return contactWebsite;
	}

	public void setContactWebsite(String contactWebsite) {
		this.contactWebsite = contactWebsite;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setSdkKey(SdkKey sdkKey) {
		this.sdkKey = sdkKey;
	}

	public List<Blacklist> getBlacklists() {
		return this.blacklists;
	}

	public void setBlacklists(List<Blacklist> blacklists) {
        if (blacklists == null) {
            this.blacklists.clear();
        } else {
            for (Blacklist blacklist : blacklists) {
                blacklist.setAccount(this);
            }
            this.blacklists = blacklists;
        }
	}

	public boolean addBlacklist(Blacklist blacklist) {
		blacklist.setAccount(this);
        return getBlacklists().add(blacklist);
    }

	public boolean removeBlacklist(Blacklist blacklist) {
		blacklist.setAccount(null);
        return getBlacklists().remove(blacklist);
    }

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
        if (users == null) {
            this.users.clear();
        } else {
            for (User user : users) {
                user.setAccount(this);
            }
            this.users = users;
        }
	}

	public boolean addUser(User user) {
		user.setAccount(this);
        return getUsers().add(user);
    }

	public boolean removeUser(User user) {
		user.setAccount(null);
        return getUsers().remove(user);
    }

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getTtlTokenAccess() {
		return ttlTokenAccess;
	}

	public void setTtlTokenAccess(Integer ttlTokenAccess) {
		this.ttlTokenAccess = ttlTokenAccess;
	}
}