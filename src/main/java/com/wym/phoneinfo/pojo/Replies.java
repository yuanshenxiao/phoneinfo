package com.wym.phoneinfo.pojo;

import java.io.Serializable;
import java.util.Date;

public class Replies implements Serializable {

    private Long id;
    private String content;
    private Date replyTime;
    private Long infoId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public Long getInfoId() {
        return infoId;
    }
}
