package com.pirest.elas.idx.entity;

import java.io.Serializable;

public class VideoChannelPojo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long channelId;
	
	private String title;

    public VideoChannelPojo(Long channelId, String title) {
        this.channelId = channelId;
        this.title = title;
    }

    public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
