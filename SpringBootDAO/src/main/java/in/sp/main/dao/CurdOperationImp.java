package in.sp.main.dao;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.sp.main.bean.Student;
import in.sp.main.mapper.StudentMapper;

@Repository
public class CurdOperationImp implements CurdOperation {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private boolean status = false;
	
	@Override
	public boolean insertionOperation(int std_id, String std_name, String std_city) {
		    
	        String sql_query = "insert into student_details values(?,?,?)";
	        
	        int count = jdbcTemplate.update(sql_query,std_id,std_name,std_city);
	        
	        if(count > 0)
	        	status = true;
	        
		   return status;
		
	}

	@Override
	public boolean updateOperation(int std_id, String std_city) {
		
		String sql_query = "update student_details set student_city = ? where student_id = ?";
		int count = jdbcTemplate.update(sql_query,std_city,std_id);
		
		if(count > 0)
			status = true;
		
		return status;
	}

	@Override
	public boolean deleteOperation(int std_id) {
		
		String sql_query = "Delete from student_details where student_id = ?";
		int count = jdbcTemplate.update(sql_query,std_id);
		
		if(count > 0)
            status = true;
		
		return status;
		
	}

	@Override
	public List<Student> getDetails() {
		
		String sql_query = "Select * from student_details";
		List<Student> getDetails =  jdbcTemplate.query(sql_query, new StudentMapper());
		
		return getDetails;
	}

	@Override
	public Student getStudentDetail(int std_id) {
		
		String sql_query = "Select * from student_details where student_id = ? ";
	    Student std = 	jdbcTemplate.queryForObject(sql_query, new StudentMapper(), std_id);
		
	    return std;
	    
		
	}
	
	

}
