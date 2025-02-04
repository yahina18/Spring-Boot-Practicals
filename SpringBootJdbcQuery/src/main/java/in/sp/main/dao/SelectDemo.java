package in.sp.main.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import in.sp.main.bean.Student;
import in.sp.main.mapper.StudentRowMapper;

@Repository
public class SelectDemo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void selectOperation()
	{
		String sql_query = "Select * from student_details";
	    List<Student> student_list = jdbcTemplate.query(sql_query, new StudentRowMapper());
	    System.out.println("Student Details : "+student_list);	
	}
	
	public void selectOperationwithWhere()
	{   
		int student_id = 101; 
		String sql_query = "Select * from student_details where student_id = ?";
	    Student student = jdbcTemplate.queryForObject(sql_query, new StudentRowMapper(),student_id);
	    System.out.println("Student Details : "+student);	
	}
	
	public void selectOperatiofromList()
	{   
		//int student_id = 101; 
		String sql_query = "Select * from student_details";
	    List<Map<String,Object>> student = jdbcTemplate.queryForList(sql_query);
	    System.out.println("Student Details : "+student);	
	}
	
	public void selectOperationfromMap()
	{
		String sql_query = "Select * from student_details where student_id = ?";
		int id = 1001;
	    Map<String,Object> std = jdbcTemplate.queryForMap(sql_query,id);
		System.out.println("Student Details : "+std);
	}
	
	
	
}
