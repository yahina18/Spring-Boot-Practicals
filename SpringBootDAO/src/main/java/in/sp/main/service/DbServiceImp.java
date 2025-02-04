package in.sp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.bean.Student;
import in.sp.main.dao.CurdOperationImp;

@Service
public class DbServiceImp implements DbService {

	@Autowired
	private CurdOperationImp curdOp;
	
	private boolean status;
	
	@Override
	public boolean insertionOperation(int std_id, String std_name, String std_city) {
        
	     status = curdOp.insertionOperation(std_id, std_name, std_city);	
		 return status;
	}

	@Override
	public boolean updateOperation(int std_id, String std_city) {
		
		status = curdOp.updateOperation(std_id, std_city);
		return status;
		
	}

	@Override
	public boolean deleteOperation(int std_id) {
		
		status = curdOp.deleteOperation(std_id);
		return status;
	}

	@Override
	public List<Student> getDetails() {
		
		List<Student> getDetails = curdOp.getDetails();
		return getDetails;
		
	}

	@Override
	public Student getStudent(int std_id) {
		
		Student std=   curdOp.getStudentDetail(std_id);
		return std;
	}

}
