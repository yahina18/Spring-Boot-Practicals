package in.sp.main.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.sp.main.bean.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("student_id");
		String student_name = rs.getString("student_name");
		String student_city = rs.getString("student_city");
		
		Student std = new Student();
		std.setStudent_id(id);
		std.setStudent_name(student_name);
		std.setStudent_city(student_city);
		
		return std;
	}

	

}
