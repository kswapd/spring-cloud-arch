package dcits.apps;

/**
 * Created by kongxiangwen on 5/21/18 w:21.
 */
import dcits.controllers.GreetingController;
import dcits.models.People;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource(locations={"classpath:new-schemas.xml", "classpath:plain-beans.xml","classpath:mybatis/mybatis-beans.xml"})
//@ImportResource("classpath:new-schemas.xml")
@ComponentScan("dcits")
public class Application implements ApplicationContextAware {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	public static ApplicationContext context;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
		People p1 = (People)context.getBean("schemaPeople");
		People p2 = (People)context.getBean("beanPeople");
		People p3 = (People)context.getBean("configPeople");
		logger.info("---------{},{},{}", p1.getAge(),p2.getAge(),p3.getAge());
	}
}
