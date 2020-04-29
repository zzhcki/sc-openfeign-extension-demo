package com.zrq.sc.openfeign.extension;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 */
public class FeignProxyConfiguration {

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public FeignProxyAdvisor feignProxyAdvisor(FeignProxyInterceptor feignProxyInterceptor) {
        FeignProxyAdvisor feignProxyAdvisor = new FeignProxyAdvisor();
        feignProxyAdvisor.setAdvice(feignProxyInterceptor);
        // 实际项目中需要配置指定，这里只是示例
        feignProxyAdvisor.setOrder(0);
        return feignProxyAdvisor;
    }

    @Bean
    public FeignProxyInterceptor feignProxyInterceptor() {
        return new FeignProxyInterceptor();
    }

}
