package com.pirest.elas.idx.entity;

import javax.persistence.*;
import java.util.Date;

/**
 `curated_channel_id` BIGINT NOT NULL,
 `app_id` BIGINT NOT NULL,
 `region_id` INT NOT NULL,
 `curated_channel_type_id` INT NOT NULL,
 `channel_id` BIGINT NOT NULL,
 `create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `lastmodified` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 */
@Entity
@Table(name = "curated_channel")
public class CuratedChannel {

    @Id
    @Column(name = "curated_channel_id")
    private Long curatedChannelId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "app_id", nullable = false)
    private App app;

    @ManyToOne(optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @ManyToOne(optional = false)
    @JoinColumn(name = "curated_channel_type_id", nullable = false)
    private CuratedChannelType curatedChannelType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastmodified", columnDefinition = "DATETIME", insertable = false, updatable = false)
    private Date lastmodified;

    public CuratedChannel() {
    }

    public CuratedChannel(Long curatedChannelId, App app, Region region, CuratedChannelType curatedChannelType, Channel channel) {
        this.curatedChannelId = curatedChannelId;
        this.app = app;
        this.region = region;
        this.curatedChannelType = curatedChannelType;
        this.channel = channel;
    }

    public Long getCuratedChannelId() {
        return curatedChannelId;
    }

    public void setCuratedChannelId(Long curatedChannelId) {
        this.curatedChannelId = curatedChannelId;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public CuratedChannelType getCuratedChannelType() {
        return curatedChannelType;
    }

    public void setCuratedChannelType(CuratedChannelType curatedChannelType) {
        this.curatedChannelType = curatedChannelType;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }
}
