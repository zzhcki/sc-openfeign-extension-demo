package com.zrq.sc.openfeign.extension;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 * @since 2020/4/29 3:23 下午
 */
public class FeignProxyAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    @Override
    public Pointcut getPointcut() {
        return null;
    }

}
