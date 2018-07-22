package com.ay.model;

import java.io.Serializable;

/**
 * 描述：说说点赞关联表
 *
 * @author ay
 * @date 2017/9/16
 */
public class UserMoodPraiseRel implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 说说id
     */
    private String moodId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMoodId() {
        return moodId;
    }

    public void setMoodId(String moodId) {
        this.moodId = moodId;
    }
}
