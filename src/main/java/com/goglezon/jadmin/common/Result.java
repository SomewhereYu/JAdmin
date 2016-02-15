package com.goglezon.jadmin.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuwenqi@jd.com on 2016/2/14 13:13.
 */
public class Result {
    private boolean success;
    private Map<String, Object> resultMap = new HashMap();
    private String errorMsg;
    private String errorCode;
    private transient String defaultKey="data";

    public Result() {}
    public Result(boolean success) {
        this.success = success;
    }

    public void setSuccess(boolean success){
        this.success=success;
    }

    public void setData(Object object){
        this.resultMap.put(defaultKey,object);
    }

    public void setErrorMsg(String errorMsg){
        this.errorMsg=errorMsg;
    }

    public String getErrorMsg(){
        return errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess(){
        return success;
    }

    public Object getData(){
        return this.resultMap.get(defaultKey);
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String,Object> resultMap) {
        this.resultMap=resultMap;
    }

    public void setData(String key, Object data) {
        this.resultMap.put(key,data);
    }

    public Object getData(String key){
        return this.resultMap.get(key);
    }
}
