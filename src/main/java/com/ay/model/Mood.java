package com.ay.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：说说
 * Created by Ay on 2017/9/16.
 */
public class Mood implements Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 说说内容
     */
    private String content;
    /**
     * 点赞数量
     */
    private Integer praiseNum;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 发表时间
     */
    private Date publishTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
