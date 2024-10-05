package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.dao.InsertionOperation;

@SpringBootApplication
public class SpringBootNamedParameterApplication {

	public static void main(String[] args) {
	  ApplicationContext context = SpringApplication.run(SpringBootNamedParameterApplication.class, args);
	  InsertionOperation op =  context.getBean(InsertionOperation.class);
	  //op.insertOperation();
	  //op.insertOperationMap();
	  op.insertOperationBEAN();
	  
	}

}
