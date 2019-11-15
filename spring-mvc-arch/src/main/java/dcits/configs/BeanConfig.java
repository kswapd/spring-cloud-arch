package dcits.configs;


import dcits.models.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
public class BeanConfig {


	@Bean
	public People configPeople(){
		People p = new People();
		p.setAge(34);
		return p;
	}

}
