package com.example.demo.servicegateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Channel")
@Entity
public class Channel {
    @Column(name = "ChannelID")
    @Id
    private int channelId;

    @Column(name = "ChannelName")
    private String channelName;

    @Column(name = "isDisable")
    private boolean isDisable;

    @Column(name = "DateTimeModify")
    private long dateTimeModify;

    @Column(name = "UserIDModify")
    private int UserIDModify;

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public boolean isDisable() {
        return isDisable;
    }

    public void setDisable(boolean disable) {
        isDisable = disable;
    }

    public long getDateTimeModify() {
        return dateTimeModify;
    }

    public void setDateTimeModify(long dateTimeModify) {
        this.dateTimeModify = dateTimeModify;
    }

    public int getUserIDModify() {
        return UserIDModify;
    }

    public void setUserIDModify(int userIDModify) {
        UserIDModify = userIDModify;
    }
}

