package com.pirest.elas.idx.entity;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * The persistent class for the SOURCE database table.
 * 
 */
@Entity
@Table(name = "source")
public class Source implements Serializable {
	private static final long serialVersionUID = 1L;

	public enum Status {
		DISABLED, ENABLED, DELETED
	}

	@Id
	@Column(name = "source_id")
	private long sourceId;

	@Column(name = "external_source_id", length = 255)
	private String externalSourceId;

	@Column(length = 255)
	private String source;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date lastmodified;

	// bi-directional many-to-one association to Video
	@OneToMany(mappedBy = "source", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<Video> videos;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "content_partner_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private ContentPartner contentPartner;

	@Column(name = "status", length = 12, nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status = Status.ENABLED;

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

	public Source() {

	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getExternalSourceId() {
		return this.externalSourceId;
	}

	public void setExternalSourceId(String externalSourceId) {
		this.externalSourceId = externalSourceId;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<Video> getVideos() {
		return this.videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Video addVideo(Video video) {
		getVideos().add(video);
		video.setSource(this);

		return video;
	}

	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setSource(null);

		return video;
	}

	public ContentPartner getContentPartner() {
		return contentPartner;
	}

	public void setContentPartner(ContentPartner contentPartner) {
		this.contentPartner = contentPartner;
	}

}