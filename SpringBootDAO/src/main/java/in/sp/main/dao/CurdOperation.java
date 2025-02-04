package in.sp.main.dao;

import java.util.List;

import in.sp.main.bean.Student;

public interface CurdOperation {
	
	public boolean insertionOperation(int std_id, String std_name,String std_city);
    public boolean updateOperation(int std_id, String std_city);
    public boolean deleteOperation(int std_id);
    public List<Student> getDetails();
    public Student getStudentDetail(int std_id);

}
