package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChannelToSubGenreId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "channel_id")
	private Long channelId;

	@Column(name = "sub_genre_id")
	private Long subGenreId;

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Long getSubGenreId() {
		return subGenreId;
	}

	public void setSubGenreId(Long subGenreId) {
		this.subGenreId = subGenreId;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ChannelToSubGenreId) {
			ChannelToSubGenreId other = (ChannelToSubGenreId) o;
			if (other.getChannelId() == this.getChannelId() && other.getSubGenreId() == this.getSubGenreId())
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = channelId.hashCode();
		return 31 * result + subGenreId.hashCode();
	}
}
