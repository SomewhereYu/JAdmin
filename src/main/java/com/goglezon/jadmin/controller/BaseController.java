package com.goglezon.jadmin.controller;

import com.goglezon.jadmin.common.Result;
import com.google.gson.Gson;
import org.springframework.ui.ModelMap;

/**
 * Created by yuwenqi@jd.com on 2016/2/14 11:34.
 */
public class BaseController {
    private static Gson gson=new Gson();

    /**
     * 供返回JSON的服务Service层使用
     * @param result
     * @return
     */
    protected String toJson(Result result){
        return gson.toJson(result);
    }

    /**
     * 供Controller层使用，传递给Freemarker层。
     * @param modelMap
     * @param errorMsg
     */
    public static void setError(ModelMap modelMap,String errorMsg){
        modelMap.put("errorCode",-1);
        modelMap.put("errorMsg",errorMsg);
    }

    public static void setError(ModelMap modelMap,String errorCode,String errorMsg){
        modelMap.put("errorCode",errorCode);
        modelMap.put("errorMsg",errorMsg);
    }
}
