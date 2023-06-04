package schoolSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {

		System.out.println("wellcom to school Management system");

		Scanner in = new Scanner(System.in);
//		String s= "dfdfsdffefes";
//		//s+="\n";
//		System.out.print(s);
//		System.out.print(s);

		Access a = new Access();
		a.enter();
		// mohmed30121906 9900001

// 	public Student(String firstName, String lastName, String number, String email, String dateOfBirth, double Balance)

//		Student s = new Student("hamdi","salama","09825620938","hamdi55@gmail.com","12/06/2011",6000.0);
//		s.setGrade("2");
//		s.TheSujects();
//		s.writeToFile();
//		
//	

//
//		Teacher ss = new Teacher("hamed","abdallh","05631397867","omarafde3@gmail.com",2000.0,"12/02/1000", "23/11/2010");
//		ss.setGrade("1 3 4");
//		ss.writeToFile();
////		
//		Employee s2 = new Employee("hamed","abdallh","05631397867","omarafde3@gmail.com",2000.0,"12/02/1000", "23/11/2010");
//		s2.writeToFile();
////
//		Manager t = new Manager("hamed","abdallh","05631397867","omarafde3@gmail.com",2000.0,"12/02/1000", "23/11/2010");
//		t.writeToFile();

		/*
		 * ID:339038,pass:hamdi12062011,Fname:hamdi,Lname:salama,grade:4,1,num:
		 * 09825620938,email:hamdi55@gmail.com,DateOfBirth:12/06/2011,subjects:{math},
		 * DateOfhiring:27/12/2047,balance:2000.0
		 * ID:339039,pass:mohmed30121906,Fname:mohmed,Lname:said,grade:1,9,num:
		 * 05893671063,email:msaid90@gmail.com,DateOfBirth:30/12/1906,subjects:{english}
		 * ,DateOfhiring:10/08/1900,balance:2000.0
		 * ID:339040,pass:ali30121906,Fname:ali,Lname:youseef,grade:1,9,num:05890001923,
		 * email:msaid90@gmail.com,DateOfBirth:30/12/1906,subjects:{english},
		 * DateOfhiring:10/08/1900,balance:2000.0
		 * 
		 */
//		

//		t.setFname("ff");
//		t.setLname("aaa");
		// t.setGrade("2");

		// Student student1=new Student("oooo", "oooo", "oooo", "oooo", "oooo", "oooo");

	}
}