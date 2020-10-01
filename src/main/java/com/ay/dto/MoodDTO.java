package com.ay.dto;

import com.ay.model.Mood;

import java.io.Serializable;

/**
 * 描述：说说DTO
 *
 * @author Ay
 * @date 2018/1/6.
 */
public class MoodDTO extends Mood implements Serializable {
    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户的账号
     */
    private String userAccount;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
