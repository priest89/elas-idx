package com.pirest.elas.idx.entity;

import java.io.Serializable;
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

import org.springframework.util.CollectionUtils;


/**
 * The persistent class for the NETWORK database table.
 * 
 */
@Entity
@Table(name = "network") 
public class Network implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "network_id")
	private long networkId;

    @Column(length = 255, nullable = false)
    private String title;

	@Column(name = "logo_url", length = 1024)
	private String logoUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;

	//bi-directional many-to-one association to Channel
	@OneToMany(mappedBy = "network", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Channel> channels;

	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "network_type_id")
	private NetworkType networkType;
	
	@OneToMany(mappedBy = "network", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<ContentPartner> contentPartners;
	
	public List<ContentPartner> getContentPartners() {
		return contentPartners;
	}

	public void setContentPartners(List<ContentPartner> contentPartners) {
		this.contentPartners = contentPartners;
	}
	
	public void addContentPartner(ContentPartner contentPartner) {
		if(contentPartner != null && !CollectionUtils.isEmpty(this.getContentPartners())) {
			if(!this.getContentPartners().contains(contentPartner)) {
				this.getContentPartners().add(contentPartner);
				contentPartner.setNetwork(this);
			}
		}
	}
	
	public void removeContentPartner(ContentPartner contentPartner) {
		if(contentPartner != null && !CollectionUtils.isEmpty(this.getContentPartners())) {
			if(!this.getContentPartners().contains(contentPartner)) {
				this.getContentPartners().remove(contentPartner);
				contentPartner.setNetwork(null);
			}
		}
	}
	
	public boolean hasContentPartner(ContentPartner contentPartner) {
		if(contentPartner != null && !CollectionUtils.isEmpty(this.getContentPartners())) {
			if(this.getContentPartners().contains(contentPartner))
				return true;
		}
		return false;
	}
	
    public NetworkType getNetworkType() {
		return networkType;
	}

	public void setNetworkType(NetworkType networkType) {
		this.networkType = networkType;
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

	public Network() {
	}

	public long getNetworkId() {
		return this.networkId;
	}

	public void setNetworkId(long networkId) {
		this.networkId = networkId;
	}

	public Date getCreateDate() {
		return this.createDate;
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

	public List<Channel> getChannels() {
		return this.channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	
	public void addChannel(Channel channel) {
		if(channel != null && !CollectionUtils.isEmpty(this.getChannels())) {
			if(!this.getChannels().contains(channel)) {
				this.getChannels().add(channel);
				channel.setNetwork(this);
			}
		}
	}
	
	public void removeChannel(Channel channel) {
		if(channel != null && !CollectionUtils.isEmpty(this.getChannels())) {
			if(!this.getChannels().contains(channel)) {
				this.getChannels().remove(channel);
				channel.setNetwork(null);
			}
		}
	}
	
	public boolean hasContentPartner(Channel channel) {
		if(channel != null && !CollectionUtils.isEmpty(this.getChannels())) {
			if(this.getChannels().contains(channel))
				return true;
		}
		return false;
	}

/*	public Channel addChannel(Channel channel) {
		getChannels().add(channel);
		channel.setNetwork(this);

		return channel;
	}

	public Channel removeChannel(Channel channel) {
		getChannels().remove(channel);
		channel.setNetwork(null);

		return channel;
	}*/

}