package dcits.configs;

import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

@Configuration
public class MybatisConfig {


	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource druidDataSource)
	{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();

		bean.setConfigLocation(
				new DefaultResourceLoader().getResource("classpath:mybatis/mybatis-config.xml"));
		bean.setDataSource(druidDataSource);
		return bean;

	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactoryBean sqlSessionFactoryBean)
	{
		try {
			return new SqlSessionTemplate(sqlSessionFactoryBean.getObject());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	/*<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
                <property name="configLocation" value="classpath:mybatis/mybatis-config.xml" />
                <property name="dataSource" ref="druidDataSource" />
        </bean>

        <bean id = "sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate" >

                <constructor-arg index="0" ref="sqlSessionFactory" />
        </bean>*/
}
