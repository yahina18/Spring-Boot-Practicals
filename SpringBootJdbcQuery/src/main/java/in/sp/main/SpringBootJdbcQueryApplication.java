package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.dao.SelectDemo;

@SpringBootApplication
public class SpringBootJdbcQueryApplication {

	public static void main(String[] args) {
	  ApplicationContext context =	 SpringApplication.run(SpringBootJdbcQueryApplication.class, args);
	  SelectDemo select = context.getBean(SelectDemo.class);
	  select.selectOperationfromMap();
	}

}
