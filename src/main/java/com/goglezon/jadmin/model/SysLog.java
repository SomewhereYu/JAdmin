package com.goglezon.jadmin.model;

import org.springframework.stereotype.Repository;

import java.util.Calendar;

/**
 * Created by Yuwenqi on 2015/9/13.
 */
@Repository
public class SysLog {
    private int opId;
    private String userName;
    private String action;
    private String className;
    private String classObj;
    private String result;
    private long opTime=System.currentTimeMillis()/1000L;

    public int getOpId() {
        return opId;
    }

    public void setOpId(int opId) {
        this.opId = opId;
    }

    public long getOpTime() {
        return opTime;
    }

    public void setOpTime(int opTime) {
       this.opTime=opTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassObj() {
        return classObj;
    }

    public void setClassObj(String classObj) {
        this.classObj = classObj;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
