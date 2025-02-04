package in.sp.main.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DbConnection {

	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Connection getConnection()
	{
		try {
			DataSource dataSource = jdbcTemplate.getDataSource();
			Connection con = dataSource.getConnection();
			
			if(con != null)
				return con;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertOperation()
	{
		int id = 1006;
		String student_city = "Pune";
		String student_name = "Hinaaaa";
		
		String sql_query = "INSERT INTO student_details values(?,?,?)";
		int count = jdbcTemplate.update(sql_query,id,student_city,student_name);
		
		if(count > 0)
			System.out.println("Insertion Successfully!!!");
		else
			System.out.println("Insertion failed !! ");
		
	}
	
	public void updateOperation()
	{
		int id = 1006;
		String student_city = "Banglore";
		
		String sql_query = "Update student_details set student_city = ? where student_id = ?";
		 int count =  jdbcTemplate.update(sql_query,student_city,id);
		 if(count > 0)
			 System.out.println("Updation done !! ");
		 else
			 System.out.println("Updation failed !! ");
	}
	
	public void deleteOperation()
	{
		int id = 1006;
		String sql_query = "Delete from student_details where student_id = ? ";
	    int count = jdbcTemplate.update(sql_query,id);
	    if(count > 0)
			 System.out.println("Deletion done !! ");
		 else
			 System.out.println("Deletion failed !! ");
	}
	
}
