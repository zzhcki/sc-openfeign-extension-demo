package com.zrq.sc.openfeign.extension.springaop;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractGenericPointcutAdvisor;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 */
public class FeignProxyAdvisor extends AbstractGenericPointcutAdvisor {

    @Override
    public Pointcut getPointcut() {
        return new FeignProxyPointcut(FeignClient.class);
    }

}
