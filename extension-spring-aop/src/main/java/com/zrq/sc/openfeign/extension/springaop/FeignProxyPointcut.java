package com.zrq.sc.openfeign.extension.springaop;

import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

import java.lang.annotation.Annotation;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 */
public class FeignProxyPointcut extends AnnotationMatchingPointcut {

    public FeignProxyPointcut(Class<? extends Annotation> classAnnotationType) {
        super(classAnnotationType, true);
    }

}
