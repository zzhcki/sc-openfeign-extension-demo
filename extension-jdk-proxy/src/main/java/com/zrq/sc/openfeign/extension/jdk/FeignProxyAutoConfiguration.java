package com.zrq.sc.openfeign.extension.jdk;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 */
@Configuration
@ConditionalOnProperty(value = "com.xxx.feign-proxy.enabled", havingValue = "true", matchIfMissing = true)
public class FeignProxyAutoConfiguration {

    @Bean
    public TargeterBeanPostProcessor targeterBeanPostProcessor() {
        return new TargeterBeanPostProcessor();
    }

}
