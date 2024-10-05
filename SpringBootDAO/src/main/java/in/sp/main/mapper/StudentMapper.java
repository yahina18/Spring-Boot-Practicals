package in.sp.main.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.sp.main.bean.Student;

public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("Student_id");
		String name = rs.getString("Student_name");
		String city = rs.getString("Student_city");
		
		Student std = new Student();
		std.setStd_id(id);
		std.setStd_name(name);
		std.setStd_city(city);
		
		return std;
	}
   
}
