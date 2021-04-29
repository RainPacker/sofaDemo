package com.springboot.webserviceInterceptor;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class WebLogInInterceptor extends AbstractPhaseInterceptor<Message> {

    public WebLogInInterceptor() {
        super(Phase.RECEIVE);
    }

    public void handleMessage(Message message) throws Fault {
        
        
         try {
             String xml;
             InputStream is = message.getContent(InputStream.class);
             
             String encoding = (String)message.get(Message.ENCODING);
             xml = IOUtils.toString(is);
            
             System.out.println("输入报文为：" + xml);
             message.setContent(InputStream.class, new ByteArrayInputStream(xml.getBytes(encoding)));
             message.getExchange().put("idtest", xml);
         } catch (Exception e) {
             e.printStackTrace();
         } 
    }
}