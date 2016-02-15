package com.goglezon.jadmin.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;

/**
 * Created by Yuwenqi on 2015/10/9.
 */
public class ServiceTimeAdvisor implements MethodInterceptor {
    Logger logger=Logger.getLogger(ServiceTimeAdvisor.class);

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        StopWatch clock = new StopWatch();
        clock.start();
        Object obj= methodInvocation.proceed();
        clock.stop();
        Class[] params = methodInvocation.getMethod().getParameterTypes();
        String[] simpleParams = new String[params.length];
        for (int i = 0; i < params.length; i++) {
            simpleParams[i] = params[i].getSimpleName();
        }
        logger.error("The Method Costs:" + clock.getTime() + " ms ["
                + methodInvocation.getThis().getClass().getName() + "."
                + methodInvocation.getMethod().getName() + "(" + StringUtils.join(simpleParams, ",") + ")] ");

        return obj;
    }
}
