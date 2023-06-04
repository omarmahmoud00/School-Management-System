package schoolSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Access {

	static int times = 0;

	static Scanner in = new Scanner(System.in);

	public void enter() throws IOException {
		// Manager m=new Manager();
		try {
			if (times == 3) {
				System.out.println("please try later: ");
				return;
			}
			// mohmed30121906 9900001
//			ID:330002,pass: hamed12021000
//			ID: 1102,pass: hamed12021000, ID:330011,pass: hamed12021000
//			System.out.println("please enter your id: ");
			String id = "330010";
//			System.out.println("please enter your password: ");
//			String pass = in.next();
			String pass = "hamed12021000";
			Pattern pt = Pattern.compile("(ID:)" + id + ",pass:" + pass);
			times++;
			check(id, pass, pt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// method for checking if the id and the password are correct
	public static void check(String id, String pass, Pattern p) throws IOException {

		BufferedReader read1 = new BufferedReader(new FileReader("stud.txt"));
		BufferedReader read2 = new BufferedReader(new FileReader("TCH.txt"));
		BufferedReader read3 = new BufferedReader(new FileReader("EMPFile.txt"));
		BufferedReader read4 = new BufferedReader(new FileReader("MNGFile.txt"));

		BufferedReader[] read = { read1, read2, read3, read4 };
		int check = 0;
		String s = null;
		String c = "null";

		for (int i = 0; i < 5; i++) {

			if (i == 4 && check == 0) {
				System.out.println("enter valid id and valid password");
				Access a = new Access();
				a.enter();
			} else {
				while ((s = read[i].readLine()) != null) { // omar12021000
					c = s;
					Matcher mt = p.matcher(s);
					while (mt.find()) {
						check = 1;
					}
					if (check == 1)
						break;
				}
			}

			if (check == 1) { // check if the id and password are available or not
				if (i == 0) {
					enterStudent(c);
					break;
				} else if (i == 1) {
					enterTeacher(c);
					break;
				} else if (i == 2) {
					enterEmployee(c);
					break;
				} else if (i == 3) {
					enterManager(c);
					break;
				}

			}

		}

	}

	public static void enterStudent(String c) throws IOException {
//		GeneralOperations GOobject = new GeneralOperations();
//		MarkOperations MOobject =new MarkOperations();
		BalanceOperations bo = new BalanceOperations();
		bo.setReciveInfo(c);
		bo.setType(0);
		bo.addDeleteOptionalSubjects();

//		System.out.print("wellcom to our dear student:");
//		System.out.println("enter the new input: ");
//		String newInput = in.next(); // UpdateSubjects
//		go.UpdateDateOfBirth(c, newInput);
//		go.UpdateSubjects(c,newInput);
//		go.ChangeLastName(c,newInput);
//		go.ChangeFirstName(c,newInput);
//		go.ChangeEmail(c, newInput);
//		go.ChangePassword(c,newInput);
//		go.ChangeNumber(c,newNumber);
//		go.ShowName(c);
//	
//		MOobject.setRecive(c);
//		MOobject.prepareSubjects();
//		MOobject.addUpdateMarks();

		// /// //// ?///???//
//		ShowEmail(c);
//		ShowGrade(c);
//		ShowSubjects(c);
//		Showbalance(c);
//		ShowFinal(c);
//		Showmidterm(c);
//		ShowDateOfBirth(c);

	}

	public static void enterTeacher(String c) throws IOException {
		System.out.print("wellcom to our dear teacher ");

		BalanceOperations bo = new BalanceOperations();
		bo.setReciveInfo(c);
		bo.setType(1);
		bo.countIncrDec();

//		GeneralOperations go= new GeneralOperations();
//
//		GeneralOperations go = new GeneralOperations();
//		System.out.print("wellcom to our dear teacher:");
//		System.out.println("enter the new input: ");
//		String newInput = in.next();
////		go.UpdateLastName(c, newInput);
//		go.UpdatePassword(c, newInput);

////		System.out.print("wellcom to our dear student:");
//		go.ChangePass(c);
//		ShowName(c);
//		ShowNumber(c);
//		ShowEmail(c);
//		ShowGrade(c);
//		ShowSubjects(c);
//		Showbalance(c);
//		ShowDateOfHiring(c);
//		ShowDateOfBirth(c);
	}

	public static void enterEmployee(String c) throws IOException {
		System.out.print("wellcom to our dear Employee ");
//		
//		System.out.print("wellcom to our dear teacher ");
		GeneralOperations go = new GeneralOperations();

//		System.out.print("wellcom to our dear student:");
//		go.ChangeNumber(c);
//		ShowName(c);
//		ShowNumber(c);
//		ShowEmail(c);
//		Showbalance(c);
//		ShowDateOfHiring(c);
//		ShowDateOfBirth(c);

	}

	public static void enterManager(String c) throws IOException {
		System.out.print("wellcom to our dear manager ");
//		ShowName(c);
//		ShowNumber(c);
//		ShowEmail(c);
//		Showbalance(c);
//		ShowDateOfHiring(c);
//		ShowDateOfBirth(c);
	}

//	 ID: 9900002 ahmed12021000
//{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{

	// method to show the first and last name {s,t,e,m} ****
	// method to show the grade {s,t} ****
	// method to show the number {s,t,e,m} ****
	// method to show the email {s,t,e,m} ****

}
