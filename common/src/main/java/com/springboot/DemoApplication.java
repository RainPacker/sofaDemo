package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {"com.facade.service","com.springboot.controller","com.springboot.listener"})
@ImportResource(locations = {"classpath*:/webservice/webservice-client.xml","classpath*:/dubbo/dubbo-consumer.xml","classpath*:/sofa/sofa-integration.xml"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
