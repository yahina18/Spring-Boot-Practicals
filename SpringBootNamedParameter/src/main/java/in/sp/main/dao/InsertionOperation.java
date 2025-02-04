package in.sp.main.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import in.sp.main.bean.Student;

@Repository
public class InsertionOperation {

	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;
	
	public void insertOperation()
	{
		Map<String,Object> map = new HashMap<>();
		map.put("key_student_id", 1005);
		map.put("key_student_city", "Lucknow");
		map.put("key_student_name", "HinaYadav");
		
		String sql_query = "Insert into student_details values(:key_student_id,:key_student_city,:key_student_name)";
		int count = npJdbcTemplate.update(sql_query, map);
		
		if(count > 0)
			System.out.println(" Success ");
		else
			System.out.println(" Failed ");
		
	}
	
	//MapSqlParameter
	public void insertOperationMap()
	{
		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("key_student_id", 1006);
		mapSql.addValue("key_student_city", "Pune");
		mapSql.addValue("key_student_name", "Rinn");
		
		String sql_query = "Insert into student_details values(:key_student_id,:key_student_city,:key_student_name)";
		int count = npJdbcTemplate.update(sql_query, mapSql);
		
		if(count > 0)
			System.out.println(" Success ");
		else
			System.out.println(" Failed ");
		
	}
	
	public void insertOperationBEAN()
	{
		Student std = new Student();
		std.setStudent_id(1007);
		std.setStudent_name("Nina");
		std.setStudent_city("Banars");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(std);
		String sql_query = "Insert into student_details values(:student_id,:student_city,:student_name)";
		int count = npJdbcTemplate.update(sql_query,param);
		
		if(count > 0)
			System.out.println(" Success ");
		else
			System.out.println(" Failed ");
		
	}
	
}
