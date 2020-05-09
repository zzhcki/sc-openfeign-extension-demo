package com.zrq.sc.openfeign.extension.jdk;

import feign.Target;
import org.springframework.cloud.openfeign.FeignContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 */
public class BizInvocationHandler implements InvocationHandler {

    private final FeignContext feignContext;

    private final Target.HardCodedTarget<?> target;

    private final InvocationHandler defaultInvocationHandler;

    public BizInvocationHandler(FeignContext feignContext, Target.HardCodedTarget<?> target, Object defaultTargeterResult) {
        this.feignContext = feignContext;
        this.target = target;
        this.defaultInvocationHandler = Proxy.getInvocationHandler(defaultTargeterResult);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if (condition()) {
            //  todo something
            // remove it
            System.out.println("complete proxy" + "method: " + method.toString());
        } else {
            result = defaultInvocationHandler.invoke(proxy, method, args);
        }
        return result;
    }

    private boolean condition() {
        // todo something
        return true;
    }
}
