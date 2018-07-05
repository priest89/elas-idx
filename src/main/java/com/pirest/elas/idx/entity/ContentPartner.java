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


/**
 * The persistent class for the CONTENT_PARTNER database table.
 * 
 */
@Entity
@Table(name = "content_partner")
public class ContentPartner implements Serializable {
	private static final long serialVersionUID = 1L;

	public enum Status {
		ENABLED,
		DISABLED,
		DELETED
    }
	
	@Id
	@Column(name = "content_partner_id")
	private long contentPartnerId;

    @Column(length = 255, nullable = false)
	private String name;

	@Column(name = "content_partner_guid", length = 25, nullable = false)
	private String contentPartnerGuid;

	@Column(name = "status")
	private String statusName;
	
	//bi-directional many-to-one association to Blacklist
	@OneToMany(mappedBy = "contentPartner", cascade = {CascadeType.REFRESH})
	private List<Blacklist> blacklists;

	//bi-directional many-to-one association to Channel
	/*@OneToMany(mappedBy = "contentPartner", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Channel> channels;*/

	//bi-directional many-to-one association to Feed
	@OneToMany(mappedBy = "contentPartner", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Feed> feeds;
	
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "network_id")
    private Network network;

	//bi-directional many-to-one association to Video
	@OneToMany(mappedBy = "contentPartner", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Video> videos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contentPartner", cascade = CascadeType.ALL)
	private List<Source> source;
	
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

    public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public ContentPartner() {
	}

	public long getContentPartnerId() {
		return this.contentPartnerId;
	}

	public void setContentPartnerId(long contentPartnerId) {
		this.contentPartnerId = contentPartnerId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentPartnerGuid() {
		return this.contentPartnerGuid;
	}

	public void setContentPartnerGuid(String contentPartnerGuid) {
		this.contentPartnerGuid = contentPartnerGuid;
	}

	public List<Blacklist> getBlacklists() {
		return this.blacklists;
	}

	public void setBlacklists(List<Blacklist> blacklists) {
		this.blacklists = blacklists;
	}

	public Blacklist addBlacklist(Blacklist blacklist) {
		getBlacklists().add(blacklist);
		blacklist.setContentPartner(this);

		return blacklist;
	}

	public Blacklist removeBlacklist(Blacklist blacklist) {
		getBlacklists().remove(blacklist);
		blacklist.setContentPartner(null);

		return blacklist;
	}

	/*public List<Channel> getChannels() {
		return this.channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public Channel addChannel(Channel channel) {
		getChannels().add(channel);
		channel.setContentPartner(this);

		return channel;
	}

	public Channel removeChannel(Channel channel) {
		getChannels().remove(channel);
		channel.setContentPartner(null);

		return channel;
	}
*/
	public List<Feed> getFeeds() {
		return this.feeds;
	}

	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}

	public Feed addFeed(Feed feed) {
		getFeeds().add(feed);
		feed.setContentPartner(this);

		return feed;
	}

	public Feed removeFeed(Feed feed) {
		getFeeds().remove(feed);
		feed.setContentPartner(null);

		return feed;
	}

	public List<Video> getVideos() {
		return this.videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Video addVideo(Video video) {
		getVideos().add(video);
		video.setContentPartner(this);

		return video;
	}

	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setContentPartner(null);

		return video;
	}

	public List<Source> getSource() {
		return source;
	}

	public void setSource(List<Source> source) {
		this.source = source;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}