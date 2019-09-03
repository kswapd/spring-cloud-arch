package apps;

import java.io.IOException;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import services.DubboConsumer;

/**
 * Created by kongxiangwen on 5/15/18 w:20.
 */
@SpringBootApplication
@EnableDubbo
@ComponentScan({"services"})
@DubboComponentScan({"services"})
public class ServerMain implements ApplicationContextAware {

	private static ApplicationContext c;

	public static void main(String[] args) throws IOException {

		SpringApplication.run(ServerMain.class, args);
		System.out.println("started");
		DubboConsumer dc = c.getBean(DubboConsumer.class);
		System.out.println(dc.doSayHell("aaa"));

	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		c = applicationContext;

	}
}
