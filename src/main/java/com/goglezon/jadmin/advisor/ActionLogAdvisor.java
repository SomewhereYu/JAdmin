package com.goglezon.jadmin.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Yuwenqi on 2015/10/9.
 */
public class ActionLogAdvisor implements MethodInterceptor {
    Logger logger=Logger.getLogger(ActionLogAdvisor.class);

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch clock = new StopWatch();
        clock.start();
        Object obj= methodInvocation.proceed();
        clock.stop();

        Object[] objs=methodInvocation.getArguments();
        HttpServletRequest request=null;
        ModelMap modelMap=null;
        for(int i=0;i<objs.length;i++){
            if(objs[i] instanceof HttpServletRequest){
                request=(HttpServletRequest)objs[i];
            }else if (objs[i] instanceof ModelMap){
                modelMap=(ModelMap)objs[i];
            }
        }
        HashMap hashMap=new HashMap();
        if(request!=null){
            Enumeration<String> parameterNames=request.getParameterNames();
            while(parameterNames.hasMoreElements()){
                String name=parameterNames.nextElement();
                hashMap.put(name,request.getParameter(name));
            }
        }

        logger.info("The Method Costs:" + clock.getTime() + " ms ["
                + methodInvocation.getThis().getClass().getName() + "."
                + methodInvocation.getMethod().getName() +"; HttpServletRequest:"+hashMap.toString()
                +",ModelMap:"+modelMap+"]");
        return obj;
    }
}
