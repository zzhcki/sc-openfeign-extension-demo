package com.zrq.sc.openfeign.extension;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractGenericPointcutAdvisor;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 */
public class FeignProxyAdvisor extends AbstractGenericPointcutAdvisor {

    @Override
    public Pointcut getPointcut() {
        FeignProxyPointcut feignProxyPointcut = new FeignProxyPointcut();
        return feignProxyPointcut;
    }

}
