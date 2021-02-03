package org.sky.config.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(MsgSink.class)
public class MsgConfig {
}

