package com.goglezon.jadmin.model;

import com.goglezon.jadmin.model.group.First;
import com.goglezon.jadmin.model.group.Second;
import com.google.gson.Gson;

import javax.validation.GroupSequence;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

/**
 * Created by Yuwenqi on 2015/9/12.
 */
@Repository
@GroupSequence({First.class, Second.class, User.class})
public class User {
    @Min(value = 1,message = "{userId.empty}",groups = First.class)
    private int userId;
    @NotEmpty(message = "{userName.empty}",groups = {First.class, Second.class})
    private String userName;
    @NotEmpty(message = "{password.empty}",groups = {First.class, Second.class})
    private String password;

    private String realName;
    private String mobile;
    private String email;
    private String userDesc;
    private int loginTime;
    private int status;
    private String loginIp;
    private int userGroup;
    private String template;
    private String shortcuts;
    private int showQuicknote;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowQuicknote() {
        return showQuicknote;
    }

    public void setShowQuicknote(int showQuicknote) {
        this.showQuicknote = showQuicknote;
    }

    public String getShortcuts() {
        return shortcuts;
    }

    public void setShortcuts(String shortcuts) {
        this.shortcuts = shortcuts;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public int getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(int userGroup) {
        this.userGroup = userGroup;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(int loginTime) {
        this.loginTime = loginTime;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
