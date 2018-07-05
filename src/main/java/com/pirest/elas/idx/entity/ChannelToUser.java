package com.pirest.elas.idx.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by danny on 10/20/15.
 */
@Entity
@Table(name = "channel_to_user", uniqueConstraints = {@UniqueConstraint(columnNames = {"channel_id", "user_id"})})
public class ChannelToUser implements Serializable {
   
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private ChannelToUserId pk = new ChannelToUserId();

    @Column(name = "tuner_order")
    private Integer tunerOrder;

    @MapsId("channelId")
    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    @MapsId("userId")
    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Integer getTunerOrder() {
        return tunerOrder;
    }

    public void setTunerOrder(Integer tunerOrder) {
        this.tunerOrder = tunerOrder;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
        this.pk.setChannelId(channel.getChannelId());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.pk.setUserId(user.getUserId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChannelToUser that = (ChannelToUser) o;

        if (!pk.equals(that.pk)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pk.hashCode();
        result = 31 * result + (tunerOrder != null ? tunerOrder.hashCode() : 0);
        return result;
    }
}
