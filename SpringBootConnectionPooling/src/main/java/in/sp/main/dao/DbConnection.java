package in.sp.main.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariDataSource;

@Repository
public class DbConnection {

	@Autowired
	private HikariDataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplat;
	
	public void getConnection()
	{
		try( Connection con1 = dataSource.getConnection();
			 Connection con2 = dataSource.getConnection();
			 Connection con3 = dataSource.getConnection();
		   )
		{
			int activeConnection = dataSource.getHikariPoolMXBean().getActiveConnections();
			int idleConnection = dataSource.getHikariPoolMXBean().getIdleConnections();
			int totalConnection = dataSource.getHikariPoolMXBean().getTotalConnections();
			
			System.out.println("Active Connection : "+activeConnection);
			System.out.println("Idle Connection : "+idleConnection);
			System.out.println("Total Connection : "+totalConnection);
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getConnectionThroughJDBC()
	{
		DataSource dataSource = jdbcTemplat.getDataSource();
		
		try {
			Connection con1 = dataSource.getConnection();
			Connection con2 = dataSource.getConnection();
			Connection con3 = dataSource.getConnection();
			Connection con4 = dataSource.getConnection();
			Connection con5 = dataSource.getConnection();
			Connection con6 = dataSource.getConnection();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
