package com.pirest.elas.idx.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChannelToAppId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "channel_id")
    private Long channelId;

    @Column(name = "app_id")
    private Long appId;

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ChannelToAppId) {
            ChannelToAppId other = (ChannelToAppId)o;
            if (other.getChannelId() == this.getChannelId() && other.getAppId() == this.getAppId())
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = channelId.hashCode();
        return 31 * result + appId.hashCode();
    }

}
