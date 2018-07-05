package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DefaultAppChannelsId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "app_id")
	private Long appId;
	 
	@Column(name = "channel_id")
	private Long channelId;

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	@Override
	public int hashCode() {
		int result = channelId.hashCode();
        result = 31 * result + appId.hashCode();
        return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        DefaultAppChannelsId that = (DefaultAppChannelsId) obj;

        if (!channelId.equals(that.channelId)) return false;
        if (!appId.equals(that.appId)) return false;

        return true;
	}
   
	
}
