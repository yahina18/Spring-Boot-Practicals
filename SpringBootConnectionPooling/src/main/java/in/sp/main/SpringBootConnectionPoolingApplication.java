package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.dao.DbConnection;

@SpringBootApplication
public class SpringBootConnectionPoolingApplication {

	public static void main(String[] args) {
		 ApplicationContext context =  SpringApplication.run(SpringBootConnectionPoolingApplication.class, args);
	     DbConnection dbcon =   context.getBean(DbConnection.class);
	     //dbcon.getConnection();
	     dbcon.getConnectionThroughJDBC();
	}

}
