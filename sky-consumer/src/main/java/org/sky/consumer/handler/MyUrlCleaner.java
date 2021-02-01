package org.sky.consumer.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.UrlCleaner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 清理URL
 **/
@Slf4j
@Component
public class MyUrlCleaner implements UrlCleaner {

    @Override
    public String clean(String originUrl) {
        String[] split = originUrl.split("/");
        // 将数字转换为特定的占位标识符
        return Arrays.stream(split)
                .map(s -> NumberUtils.isNumber(s) ? "{number}" : s)
                .reduce((a, b) -> a + "/" + b)
                .orElse("");
    }
}