package in.sp.main.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.sp.main.beans.Student;

@Repository
public class BatchPreparedStatement {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void inserionOperation()
	{
		Student std1 = new Student();
		std1.setStudent_id(103);
		std1.setStudent_name("asd");
		std1.setStudent_city("Used");
		
		Student std2 = new Student();
		std1.setStudent_id(104);
		std1.setStudent_name("bnhjh");
		std1.setStudent_city("zxcvb");
		
		List<Student> list = new ArrayList<>();
		list.add(std1);
		list.add(std2);
		
		String sql_query = "Insert into student_details values(?,?,?)";
		int[]count = jdbcTemplate.batchUpdate(sql_query, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				
				Student student = list.get(index);
				ps.setInt(1, student.getStudent_id());
				ps.setString(2, student.getStudent_city());
				ps.setString(3, student.getStudent_name());
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return list.size();
			}
		});
		
		for(int i : count)
			System.out.println("Success : "+i);
	}
}
