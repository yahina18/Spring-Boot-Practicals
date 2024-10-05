package in.sp.main;

import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//import in.sp.main.dao.DbConnection;

@SpringBootApplication
public class SpringBootDataSourceApplication {

	public static void main(String[] args) {
		 ApplicationContext context =  SpringApplication.run(SpringBootDataSourceApplication.class, args);
			/*
			 * // DbConnection dbCon = context.getBean(DbConnection.class); // Connection
			 * con = dbCon.getConnection(); if(con != null)
			 * System.out.println("Connection Established !! "); else
			 * System.out.println(" Connection failed !! ");
			 * 
			 * // dbCon.insertOperation(); // dbCon.updateOperation();
			 * dbCon.deleteOperation();
			 */
	     
	}

}
