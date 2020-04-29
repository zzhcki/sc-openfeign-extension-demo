package com.zrq.sc.openfeign.extension;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 * @since 2020/4/29 3:17 下午
 */
@Configuration
public class FeignProxyConfiguration {

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public FeignProxyAdvisor feignProxyAdvisor(FeignProxyInterceptor feignProxyInterceptor) {
        FeignProxyAdvisor feignProxyAdvisor = new FeignProxyAdvisor();
        feignProxyAdvisor.setAdvice(feignProxyInterceptor);
        return feignProxyAdvisor;
    }

    @Bean
    public FeignProxyInterceptor feignProxyInterceptor() {
        return new FeignProxyInterceptor();
    }

}
