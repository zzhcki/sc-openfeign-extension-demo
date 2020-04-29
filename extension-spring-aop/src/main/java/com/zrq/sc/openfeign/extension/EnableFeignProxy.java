package com.zrq.sc.openfeign.extension;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;

import java.lang.annotation.*;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 * @since 2020/4/29 3:02 下午
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ConfigSelector.class})
public @interface EnableFeignProxy {

    /**
     * Indicate how caching advice should be applied. The default is
     * {@link AdviceMode#PROXY}.
     *
     * @see AdviceMode
     */
    AdviceMode mode() default AdviceMode.PROXY;

    /**
     * Indicate the ordering of the execution of the caching advisor
     * when multiple advices are applied at a specific joinpoint.
     * The default is {@link Ordered#LOWEST_PRECEDENCE}.
     */
    int order() default Ordered.LOWEST_PRECEDENCE;

}
