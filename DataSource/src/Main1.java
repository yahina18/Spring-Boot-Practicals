import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Main1 {

	public static void main(String[] args) {

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://localhost:3306/practice");
            config.setUsername("root");
            config.setPassword("Ravina1997");
            config.setMaximumPoolSize(10);
            
            HikariDataSource dataSource = new HikariDataSource(config);
            try(Connection con = dataSource.getConnection();
            	PreparedStatement ps = con.prepareStatement("insert into student_details values(?,?,?)");	
            		
               )
            {
            	
            	//Register HikariCP pool as an mbean
            	
            	MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            	
            	ObjectName poolObjectName = new ObjectName("com.zaxxer.hikari:type=Pool("+dataSource.getPoolName()+")");
            	mBeanServer.registerMBean(dataSource.getHikariPoolMXBean(), poolObjectName);
            	
            	//access the pool statics using JMX 
            	int activeConnection = (int)mBeanServer.getAttribute(poolObjectName, "ActiveConnections");
            	int idleConnection = (int)mBeanServer.getAttribute(poolObjectName, "IdleConnections");
                int totalConnection = activeConnection + idleConnection;
            	
            	System.out.println("Active Connection : "+activeConnection);
            	System.out.println("idle Connection : "+idleConnection);
            	System.out.println("Total Connection : "+totalConnection);
            
            	
            	ps.setInt(1, 1003);
            	ps.setString(2, "Nagpur");
            	ps.setString(3, "RinaYadav");
            	
            	int row = ps.executeUpdate();
            	if(row > 0)
            		System.out.println("Row Inserted Successfully !! ");
            	else
            		System.out.println("Please try again !! ");
            	
            }catch (Exception e) {
				e.printStackTrace();
			}

	}

}
