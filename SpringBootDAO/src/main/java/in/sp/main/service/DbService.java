package in.sp.main.service;

import java.util.List;

import in.sp.main.bean.Student;

public interface DbService {
	
	public boolean insertionOperation(int std_id, String std_name, String std_city);
	public boolean updateOperation(int std_id, String std_city);
    public boolean deleteOperation(int std_id);
    public List<Student> getDetails();
    public Student getStudent(int std_id); 
}
