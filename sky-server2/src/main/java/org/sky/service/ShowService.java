package org.sky.service;

/**
 * created by albert on 2021/2/1
 */
public interface ShowService {


    /**
     * 对外提供的dubbo服务
     * @param message
     * @return
     */
    String show(String message);

}
