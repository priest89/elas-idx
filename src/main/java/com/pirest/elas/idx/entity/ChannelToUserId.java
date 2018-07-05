package com.pirest.elas.idx.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by danny on 10/20/15.
 */
@Embeddable
public class ChannelToUserId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "channel_id")
    private Long channelId;
    @Column(name = "user_id")
    private Long userId;

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChannelToUserId that = (ChannelToUserId) o;

        if (!channelId.equals(that.channelId)) return false;
        if (!userId.equals(that.userId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = channelId.hashCode();
        result = 31 * result + userId.hashCode();
        return result;
    }
}
