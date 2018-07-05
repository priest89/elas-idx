package com.pirest.elas.idx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 `curated_channel_type_id` INT NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(45) NOT NULL,
 */
@Entity
@Table(name = "curated_channel_type")
public class CuratedChannelType {

    @Id
    @Column(name = "curated_channel_type_id")
    private Long curatedChannelTypeId;

    @Column(name = "name", unique = true, columnDefinition = "VARCHAR(45)", length = 45)
    private String name;

    public CuratedChannelType() {
    }

    public CuratedChannelType(String name) {
        this.name = name;
    }

    public Long getCuratedChannelTypeId() {
        return curatedChannelTypeId;
    }

    public void setCuratedChannelTypeId(Long curatedChannelTypeId) {
        this.curatedChannelTypeId = curatedChannelTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
