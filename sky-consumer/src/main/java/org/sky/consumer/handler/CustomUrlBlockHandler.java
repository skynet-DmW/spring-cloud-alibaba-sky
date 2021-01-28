package org.sky.consumer.handler;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义流控异常处理
 * created by albert on 2021/1/28
 */
@Slf4j
public class CustomUrlBlockHandler implements UrlBlockHandler {

    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {
        log.error("错误信息：{}", e.getMessage(), e);
        response.getWriter().println("自定义流控异常处理");
    }

}


