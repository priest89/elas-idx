package com.pirest.elas.idx.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the CHANNEL_TYPE database table.
 * 
 */
@Entity
@Table(name = "channel_type")
public class ChannelType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "channel_type_id")
	private long channelTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
	private Date lastmodified;

	@Column(name = "type_name")
	private String typeName;

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

	public ChannelType() {
	}

	public long getChannelTypeId() {
		return this.channelTypeId;
	}

	public void setChannelTypeId(long channelTypeId) {
		this.channelTypeId = channelTypeId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public Date getLastmodified() {
		return this.lastmodified;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

//	public Channel addChannel(Channel channel) {
//		getChannels().add(channel);
//		channel.setChannelType(this);
//
//		return channel;
//	}
//
//	public Channel removeChannel(Channel channel) {
//		getChannels().remove(channel);
//		channel.setChannelType(null);
//
//		return channel;
//	}

}