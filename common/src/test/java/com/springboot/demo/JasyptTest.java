/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.demo;


import org.jasypt.intf.cli.JasyptPBEStringDecryptionCLI;
import org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI;
import org.jasypt.intf.service.JasyptStatelessService;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;
import org.junit.Test;
import org.springframework.util.Base64Utils;

import java.util.Base64;
import java.util.Properties;

/**
 * @author rain
 * @version : JasyptTest.java, v 0.1 2020年12月22日 下午5:05 rain Exp $
 */
public class JasyptTest {

    @Test
    public  void test(){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        ////加密所需的salt(盐)
        //textEncryptor.setPassword("uoj20@d03jd");
        //textEncryptor.
        ////要加密的数据（数据库的用户名或密码）
        //  String username = textEncryptor.encrypt("root");
        //String password = textEncryptor.encrypt("myadmin");
        //        System.out.println("username:"+username);
        //System.out.println("password:"+password);
    }
   @Test
    public  void  testEnc(){
        try {

            JasyptStatelessService service = new JasyptStatelessService();
            String input = "root";//原密码
            String password ="root";//salt;
            String algorithm=null;
            String keyObtentionIterations=null;
            String saltGeneratorClassName=null;
            String providerName=null;
            String providerClassName=null;
            String stringOutputType=null;

            String result = service.encrypt(input, password, (String)null, (String)null,algorithm, (String)null, (String)null, keyObtentionIterations, (String)null, (String)null, saltGeneratorClassName, (String)null, (String)null, providerName, (String)null, (String)null, providerClassName, (String)null, (String)null, stringOutputType, (String)null, (String)null);
            System.out.println(result);
        } catch (Throwable var8) {

        }
    }

    @Test
    public  void  testDec(){

        try {






            String input = Base64Utils.encodeToUrlSafeString("o3fr+RoUfUUyi1RoTvUkVAQ+SaVZvJhjRrs157l8mrxWJ2PlA6vmsx41aU+8L9dr".getBytes()) ;//原密文
            String password ="tkcloud1234";//salt;
            String algorithm="PBEWithMD5AndDES";
            String keyObtentionIterations=null;
            String saltGeneratorClassName=null;
            String providerName=null;
            String providerClassName=null;
            String stringOutputType=null;

           JasyptPBEStringDecryptionCLI.main(new String[]{input,password});


            JasyptStatelessService service = new JasyptStatelessService();

            String result = service.decrypt(input, password, (String)null, (String)null, algorithm, (String)null, (String)null,keyObtentionIterations, (String)null, (String)null, saltGeneratorClassName, (String)null, (String)null, providerName, (String)null, (String)null,providerClassName, (String)null, (String)null, stringOutputType, (String)null, (String)null);
            System.out.println(result);
        } catch (Throwable var8) {

        }
    }

    @Test
    public void jasyptTest() {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        // application.properties, jasypt.encryptor.password
        encryptor.setPassword("tkcloud1234");
        // encrypt root
        System.out.println(encryptor.encrypt("root"));
        System.out.println(encryptor.encrypt("root"));
        System.out.println(encryptor.encrypt("root"));

        // decrypt, the result is root
        System.out.println(encryptor.decrypt("o3fr+RoUfUUyi1RoTvUkVAQ+SaVZvJhjRrs157l8mrxWJ2PlA6vmsx41aU+8L9dr"));



    }

    @Test
    public void jasyptTest2() {
        StrongTextEncryptor encryptor = new StrongTextEncryptor();
        // application.properties, jasypt.encryptor.password
        encryptor.setPassword("tkcloud1234");
        // encrypt root
        System.out.println(encryptor.encrypt("root"));
        System.out.println(encryptor.encrypt("root"));
        System.out.println(encryptor.encrypt("root"));

        // decrypt, the result is root
        System.out.println(encryptor.decrypt("o3fr+RoUfUUyi1RoTvUkVAQ+SaVZvJhjRrs157l8mrxWJ2PlA6vmsx41aU+8L9dr"));
        System.out.println(encryptor.decrypt("QVp9vmFQaiR55KP9HdtT+g=="));
        System.out.println(encryptor.decrypt("ENAV9R0dZ6yqPUuXlsX96g=="));


    }
}
