package in.sp.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BatchUpdation {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void jdbcBatchUpdation()
	{
		String sql_query1 = "Insert into student_details values('101','Mumbai','Hina')";
		String sql_query2 = "Insert into student_details values('102','Pune','Hina')";
	    String [] sql_queries = {sql_query1,sql_query2};
	    int []count = jdbcTemplate.batchUpdate(sql_queries);
	    
	    for(int i : count)
	    	System.out.println("Success : "+i);
	
	}
}
