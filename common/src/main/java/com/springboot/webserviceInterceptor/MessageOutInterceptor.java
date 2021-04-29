package com.springboot.webserviceInterceptor;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MessageOutInterceptor extends AbstractPhaseInterceptor<Message> {
    @SuppressWarnings("unused")
    private String mMessage;
    
    public MessageOutInterceptor() {
        super(Phase.PRE_STREAM);
    }

   public void handleMessage(Message message) throws Fault {
       String xml;
         try {
            
             String inputXML = (String) message.getExchange().get("idtest"); 
             System.out.println("输入信息：：：："+inputXML);
             OutputStream os = message.getContent(OutputStream.class);
             CachedOutputStream cs = new CachedOutputStream();
             message.setContent(OutputStream.class, cs);
             message.getInterceptorChain().doIntercept(message);
             CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);
             InputStream in = csnew.getInputStream();
             xml = IOUtils.toString(in);
             System.out.println("输出信息：" + xml);
             IOUtils.copy(new ByteArrayInputStream(xml.getBytes()), os);
             cs.close();
             os.flush();
             message.setContent(OutputStream.class, os); 
            
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
   
  
}