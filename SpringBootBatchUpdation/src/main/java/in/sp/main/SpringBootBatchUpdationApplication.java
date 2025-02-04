package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.dao.BatchPreparedStatement;
import in.sp.main.dao.BatchUpdation;
import in.sp.main.dao.BatchUpdationUsingNamedParameter;

@SpringBootApplication
public class SpringBootBatchUpdationApplication {

	public static void main(String[] args) {
	  ApplicationContext context = SpringApplication.run(SpringBootBatchUpdationApplication.class, args);
		/*
		 * BatchUpdation update = context.getBean(BatchUpdation.class);
		 * update.jdbcBatchUpdation();
		 */
	  
		/*
		 * BatchPreparedStatement update =
		 * context.getBean(BatchPreparedStatement.class); update.inserionOperation();
		 */
	     
	  BatchUpdationUsingNamedParameter batchUpdate = context.getBean(BatchUpdationUsingNamedParameter.class);
	  //batchUpdate.insertOperation();
	  batchUpdate.insertionWithSqlQuery();
	}

}
