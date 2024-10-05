package in.sp.main.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import in.sp.main.beans.Student;

@Repository
public class BatchUpdationUsingNamedParameter {

	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;
	
	public void insertOperation()
	{
		Map<String,Object> map1 = new HashMap<>();
		map1.put("key_student_id", 106);
		map1.put("key_student_city", "Mumbai");
		map1.put("key_student_name", "hhhhhh");
		
		Map<String,Object> map2 = new HashMap<>();
		map2.put("key_student_id", 107);
		map2.put("key_student_city", "hyderabad");
		map2.put("key_student_name", "h788h");
		
		Map[]map = {map1,map2};
		
		String sql_query = "Insert into student_details values(:key_student_id,:key_student_city,:key_student_name)";
        int[] count = npJdbcTemplate.batchUpdate(sql_query, map);
        
        for(int i : count)
        	System.out.println("Success : "+i);	
	}
	
	public void insertionWithSqlQuery()
	{
		Student std1 = new Student();
		std1.setStudent_id(1007);
		std1.setStudent_city("Bedrffyh");
		std1.setStudent_name("dgj");
		
		Student std2 = new Student();
		std2.setStudent_id(1008);
		std2.setStudent_city("Bdfedrffyh");
		std2.setStudent_name("dgfrj");
		
		List<Student> student_list = new ArrayList<>();
		student_list.add(std1);
		student_list.add(std2);
		
		SqlParameterSource [] batch = SqlParameterSourceUtils.createBatch(student_list.toArray());
	    
		String sql_query = "Insert into student_details values(:student_id,:student_name,:student_city)";
        int[]count = npJdbcTemplate.batchUpdate(sql_query,batch);
        
        for(int i : count)
        	System.out.println("Success : "+i);
		
	}
}
