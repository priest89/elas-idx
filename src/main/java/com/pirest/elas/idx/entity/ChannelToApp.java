package com.pirest.elas.idx.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "channel_to_app", uniqueConstraints = {@UniqueConstraint(columnNames = {"channel_id", "app_id"})})
public class ChannelToApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ChannelToAppId pk = new ChannelToAppId();

    @MapsId("channelId")
    @JoinColumn(name = "channel_id", nullable = false)
    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    private Channel channel;

    @MapsId("appId")
    @JoinColumn(name = "app_id", nullable = false)
    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    private App app;

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
    public boolean equals(Object o) {
        if (o instanceof ChannelToApp)
            if (pk.equals(((ChannelToApp) o).pk))
                return true;
        return false;
    }

    @Override
    public int hashCode() {
        return pk.hashCode();
    }

}
