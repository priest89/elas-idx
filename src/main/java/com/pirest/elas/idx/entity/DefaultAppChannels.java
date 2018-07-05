package com.pirest.elas.idx.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "default_app_channels", uniqueConstraints = {@UniqueConstraint(columnNames = {"channel_id", "app_id"})})
public class DefaultAppChannels implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private DefaultAppChannelsId pk = new DefaultAppChannelsId();

    @Column(name = "channel_order")
    private Integer channelOrder;

    @MapsId("channelId")
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    @MapsId("appId")
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", nullable = false)
    private App app;

	public Integer getChannelOrder() {
		return channelOrder;
	}

	public void setChannelOrder(Integer channelOrder) {
		this.channelOrder = channelOrder;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		DefaultAppChannels that = (DefaultAppChannels) o;

		if (!pk.equals(that.pk))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = pk.hashCode();
		result = 31 * result + (channelOrder != null ? channelOrder.hashCode() : 0);
		return result;
	}

}
