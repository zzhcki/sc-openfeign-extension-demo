package com.zrq.sc.openfeign.extension;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 */
public class FeignProxyPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        Class<?> targetClass = ClassUtils.getUserClass(aClass);
        FeignClient feignClient = AnnotationUtils.findAnnotation(targetClass, FeignClient.class);
        if (feignClient != null) {
            return true;
        }
        return false;
    }

}
