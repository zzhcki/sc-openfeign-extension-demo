package com.zrq.sc.openfeign.extension;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.annotation.AutoProxyRegistrar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:zzhcki@gmail.com">zhangruiquan</a>
 * @since 2020/4/29 3:04 下午
 */
public class ConfigSelector extends AdviceModeImportSelector<EnableFeignProxy> {

    @Override
    protected String[] selectImports(AdviceMode adviceMode) {

        switch (adviceMode) {
            case PROXY:
                return getImports();
            default:
                return null;
        }

    }

    private String[] getImports() {
        List<String> result = new ArrayList<>();
        result.add(FeignProxyConfiguration.class.getName());
        result.add(AutoProxyRegistrar.class.getName());
        return result.toArray(new String[0]);
    }

}
