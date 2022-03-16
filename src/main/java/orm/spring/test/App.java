package orm.spring.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
    ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    StudentDao dao = context.getBean("studentDao",StudentDao.class);
    
   
    
    boolean status=true;
    do 
    
    {
    	BufferedReader ob = new BufferedReader(new InputStreamReader (System.in));
    	System.out.println("=========================================================");
		System.out.println("1->Add Student Record\n"+"2->View all Student records\n"+
						   "3->View Student Record\n"+"4->Update Student record\n"+
						   "5->Delete Student Record\n"+"6->Exit");
		System.out.println("=========================================================");
		
		
		System.out.println("Enter your Choice:");
		int choice = Integer.parseInt(ob.readLine());
		
		
		switch(choice)
		{
		case 1:  System.out.println("Enter student id:");
		 int sid=Integer.parseInt(ob.readLine());
		 System.out.println("Enter student Name:");
		 String sname=ob.readLine();
		 System.out.println("Enter student Address:");
		 String saddress=ob.readLine();
		 
		 Student s=new Student(sid,sname,saddress);
		 if(dao.addStudent(s)>0)
		 {
			 System.out.println("Record Added!");
		 }
		 else
		 {
			 System.out.println("Error Occurred!");
		 }
		 break;
		 
		 
		case 2 :
			List<Student> slist = dao.getAllStudents();
			for(Student st : slist)
			{
				System.out.println(st.getStudentId()+"\n"+st.getStudentName()+"\n"+st.getStudentCity());
			}
			break;
			
		case 3 :
		   System.out.println("Enter Student Id :");
		   sid=Integer.parseInt(ob.readLine());
		   Student st = dao.getStudent(sid);
		   System.out.println(st.getStudentId()+"\n"+st.getStudentName()+"\n"+st.getStudentCity());

		break;

		case 4:
		   System.out.println("Enter existing student id:");
		  sid=Integer.parseInt(ob.readLine());
		  System.out.println("Enter new student Name:");
		  sname=ob.readLine();
		  System.out.println("Enter new student Address:");
		  saddress=ob.readLine(); 
		  
		  s=new Student(sid,sname,saddress);
		  dao.studentUpdate(s);
		  System.out.println("Record Updated!!");
		  break;
		  
		case 5:
		System.out.println("Enter existing student id to delete:");
  		sid=Integer.parseInt(ob.readLine());	  
	    dao.studentDelete(sid);
	    System.out.println("Record Deleted!!");
	    break;
	    
		case 6:
			System.out.println("Good Bye!");
	       status=false;
	       break;
	    
		
			default:
				System.out.println("Wrong Choice!!!");
		  
			
		 
	}
    	
		
		
    }
    while(status);
    
    
    
    
    
    }
}
