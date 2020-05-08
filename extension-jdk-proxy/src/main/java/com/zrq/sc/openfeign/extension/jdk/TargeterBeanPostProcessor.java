package com.zrq.sc.openfeign.extension.jdk;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 */
public class TargeterBeanPostProcessor implements BeanPostProcessor, BeanClassLoaderAware {

    public static final String TARGETER_CLASS_NAME = "org.springframework.cloud.openfeign.Targeter";

    private ClassLoader beanClassLoader;


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        // spring-cloud-alibaba-dubbo使用了该种方式替换feign的调用为dubbo实现
        if (ClassUtils.isPresent(TARGETER_CLASS_NAME, this.beanClassLoader)) {
            Class<?> beanActualClass = ClassUtils.getUserClass(bean);
            Class<?> targeterClass = ClassUtils.resolveClassName(TARGETER_CLASS_NAME, beanClassLoader);
            if (targeterClass.isAssignableFrom(beanActualClass)) {
                return Proxy.newProxyInstance(
                        beanClassLoader,
                        new Class[]{targeterClass},
                        new TargeterInvocationHandler(bean, beanName, beanActualClass));
            }
        }
        return bean;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;

    }
}
