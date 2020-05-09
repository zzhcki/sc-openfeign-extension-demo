package com.zrq.sc.openfeign.extension.springaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 */
public class FeignProxyInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // todo something
            Object result = null;
        if (condition()) {
            // remove it
            System.out.println("complete proxy" + "method: " + methodInvocation.getMethod().toString());
        } else {
            result = methodInvocation.getMethod()
                    .invoke(methodInvocation.getThis(),
                            methodInvocation.getArguments());
        }
        return result;
    }

    private boolean condition() {
        // todo something
        return true;
    }

}
