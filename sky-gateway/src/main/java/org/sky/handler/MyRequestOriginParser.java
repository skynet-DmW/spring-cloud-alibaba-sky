package org.sky.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 实现区分来源
 */
@Slf4j
@Component
public class MyRequestOriginParser implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        // 从header中获取名为 Host 的参数并返回
        String host = request.getHeader("Host");
        if (StringUtils.isBlank(host)) {
            // 如果获取不到，则抛异常
            String err = "host param must not be blank!";
            log.error("parse host failed: {}", err);
            throw new IllegalArgumentException(err);
        }
        return host;
    }

}
