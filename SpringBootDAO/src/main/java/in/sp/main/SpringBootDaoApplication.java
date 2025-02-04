package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.service.DbService;
import in.sp.main.service.DbServiceImp;

@SpringBootApplication
public class SpringBootDaoApplication {

	public static void main(String[] args) {
		 ApplicationContext context =  SpringApplication.run(SpringBootDaoApplication.class, args);
	     DbService dbService  =  context.getBean(DbServiceImp.class);
	     //System.out.println("Insertion Operation done ? "+dbService.insertionOperation(203, "Mwser", "sfdg"));
         //System.out.println("Updation Done ? "+dbService.updateOperation(203, "Mumbai"));
	   //System.out.println("Deletion Done ? "+dbService.deleteOperation(203));
	
	     //System.out.println("All Student Details : "+dbService.getDetails());
	     System.out.println("Student Details : "+dbService.getStudent(101));
	}

}
