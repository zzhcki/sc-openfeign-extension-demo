package com.zrq.sc.openfeign.extension;

import feign.Target;
import org.springframework.cloud.openfeign.FeignContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 */
public class TargeterInvocationHandler implements InvocationHandler {

    private final Object bean;

    private final String beanName;

    private final Class<?> beanClass;

    public TargeterInvocationHandler(Object bean, String beanName, Class<?> beanClass) {
        this.bean = bean;
        this.beanName = beanName;
        this.beanClass = beanClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        FeignContext feignContext = (FeignContext) args[2];
        Target.HardCodedTarget<?> hardCodedTarget = (Target.HardCodedTarget<?>) args[3];

        if (System.getSecurityManager() != null) {
            AccessController.doPrivileged((PrivilegedAction<Object>) () -> {
                method.setAccessible(true);
                return null;
            });
        } else {
            method.setAccessible(true);
        }

        Object defaultTargeterResult = method.invoke(bean, args);

        return Proxy.newProxyInstance(
                hardCodedTarget.type().getClassLoader(),
                new Class[]{hardCodedTarget.type()},
                new BizInvocationHandler(feignContext, hardCodedTarget, defaultTargeterResult));
    }
}
