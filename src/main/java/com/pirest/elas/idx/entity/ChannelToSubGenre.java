package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "channel_to_sub_genre", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "channel_id", "sub_genre_id" }) })
public class ChannelToSubGenre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChannelToSubGenreId pk = new ChannelToSubGenreId();

	@MapsId("channelId")
	@JoinColumn(name = "channel_id", nullable = false)
	@ManyToOne(cascade = { CascadeType.REFRESH }, optional = false)
	private Channel channel;

	@MapsId("sub_genre_id")
	@JoinColumn(name = "sub_genre_id", nullable = false)
	@ManyToOne(cascade = { CascadeType.REFRESH }, optional = false)
	private SubGenre subGenre;

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public SubGenre getSubGenre() {
		return subGenre;
	}

	public void setSubGenre(SubGenre subGenre) {
		this.subGenre = subGenre;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ChannelToSubGenre)
			if (pk.equals(((ChannelToSubGenre) o).pk))
				return true;
		return false;
	}

	@Override
	public int hashCode() {
		return pk.hashCode();
	}

}
