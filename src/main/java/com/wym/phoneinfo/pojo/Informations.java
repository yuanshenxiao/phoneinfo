package com.wym.phoneinfo.pojo;

import java.io.Serializable;
import java.util.Date;

public class Informations implements Serializable {

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public Date getLastPostTime() {
        return lastPostTime;
    }

    private Long id;
    private String title;
    private String content;
    private Integer replyCount;
    private Integer viewCount;
    private Date reportTime;
    private Date lastPostTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public void setLastPostTime(Date lastPostTime) {
        this.lastPostTime = lastPostTime;
    }
}
