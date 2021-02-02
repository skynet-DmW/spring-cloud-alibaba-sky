package org.sky.config.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgModel implements Serializable {

    public static final long serialVersionUID = 1L;

    private String content;

    private long time;

}

