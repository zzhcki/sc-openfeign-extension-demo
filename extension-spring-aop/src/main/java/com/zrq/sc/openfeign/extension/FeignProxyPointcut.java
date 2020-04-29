package com.zrq.sc.openfeign.extension;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 * @since 2020/4/29 4:48 下午
 */
public class FeignProxyPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        // TODO
        return false;
    }

}
