package com.zyy.sofa;




import com.zyy.sofa.config.ConstantValue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {"com.zyy.sofa","com.facade.service"})
@MapperScan(basePackages = {"com.zyy.sofa.mapper","com.zyy.sofa.*.mapper*"})
//@ImportResource(locations = {"classpath*:/sofa/sofa-service.xml"})
@ImportResource(locations = {"classpath*:/webservice/webservicesContext.xml","classpath*:/sofa/sofa-service.xml"})
public class SofaApp {
    public static void main(String[] args) {
        /**  配置加解密跟秘钥，与配置文件的密文分开放  */


        System.setProperty("jasypt.encryptor.password", ConstantValue.JASYPT_ENCRYPTOR_PASSWORD);
        SpringApplication.run(SofaApp.class, args);
    }
}
