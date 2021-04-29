import com.zyy.sofa.config.ConstantValue;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {



 static {

  //try {
  //
  // Log4jConfigurer.initLogging("classpath:config/log4j.properties");
  //
  //} catch (FileNotFoundException ex) {
  //
  // System.err.println("Cannot Initialize log4j");
  //
  //}
  System.out.println("init...");
  System.setProperty("jasypt.encryptor.password", ConstantValue.JASYPT_ENCRYPTOR_PASSWORD);

 }



 public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {

  super(clazz);

 }



}
