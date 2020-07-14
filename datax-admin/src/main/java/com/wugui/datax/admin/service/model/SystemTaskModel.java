package com.wugui.datax.admin.service.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiahui on 2020-07-10 16:24
 */
public class SystemTaskModel implements Serializable {

    private Integer id;

    private String name;

    private Integer sourceServerId;

    private Integer cloudAccountId;

    private String cloudServerIp;

    private String targetArea;

    private Integer broadband;

    private Integer startType;

    private Date startTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSourceServerId() {
        return sourceServerId;
    }

    public void setSourceServerId(Integer sourceServerId) {
        this.sourceServerId = sourceServerId;
    }

    public Integer getCloudAccountId() {
        return cloudAccountId;
    }

    public void setCloudAccountId(Integer cloudAccountId) {
        this.cloudAccountId = cloudAccountId;
    }

    public String getCloudServerIp() {
        return cloudServerIp;
    }

    public void setCloudServerIp(String cloudServerIp) {
        this.cloudServerIp = cloudServerIp;
    }

    public String getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(String targetArea) {
        this.targetArea = targetArea;
    }

    public Integer getBroadband() {
        return broadband;
    }

    public void setBroadband(Integer broadband) {
        this.broadband = broadband;
    }

    public Integer getStartType() {
        return startType;
    }

    public void setStartType(Integer startType) {
        this.startType = startType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
