import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Main {

	public static void main(String[] args) {
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/practice");
		dataSource.setUser("root");
		dataSource.setPassword("Ravina1997");
		
		try(
				
			Connection con = dataSource.getConnection();
		    PreparedStatement ps = con.prepareStatement("insert into student_details values(?,?,?)");		
		   
			){
			
			ps.setInt(1, 1004);
			ps.setString(2, "Mumbai");
			ps.setString(3, "HinaYadav");
			
			int row = ps.executeUpdate();
			if(row > 0)
				System.out.println("Row Inserted Sucessfully!!! ");
			else 
				System.out.println(" Please try Again");
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
