package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="source_to_account_and_region", uniqueConstraints= {@UniqueConstraint(columnNames={"source_id", "account_id", "region_id"})})
public class SourceToAccountAndRegion implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SourceToAccountAndRegionPK pk = new SourceToAccountAndRegionPK();

	@MapsId("sourceId")
	@JoinColumn(name="source_id", nullable=false)
	@ManyToOne(cascade={CascadeType.REFRESH}, optional=false)
	private Source source;

	@MapsId("accountId")
	@JoinColumn(name="account_id", nullable=false)
	@ManyToOne(cascade={CascadeType.REFRESH}, optional=false)
	private Account account;

	@MapsId("regionId")
	@JoinColumn(name="region_id", nullable=false)
	@ManyToOne(cascade={CascadeType.REFRESH}, optional=false)
	private Region region;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", columnDefinition="DATETIME", insertable=false, updatable=false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="lastmodified", columnDefinition="DATETIME", insertable=false, updatable=false)
	private Date lastModified;

	@PrePersist
	public void onCreate() {
		Date date = new Date();
		this.createDate = date;
		this.lastModified = date;
	}

	@PreUpdate
	public void onUpdate() {
		this.lastModified = new Date();
	}
	
	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
		SourceToAccountAndRegion other = (SourceToAccountAndRegion) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}

}
