package schoolSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralOperations {

	Scanner in = new Scanner(System.in);

	Pattern pt;
	Matcher mt;
	String s = null;
	String info = null;

	public void setInfo(String info) {
		this.info = info;
	}

	FileReadWrite fr = new FileReadWrite();

	// methods of changing information

	// method to update the date of hiring
	public String UpdateDateOfHiring(String oldInfo, String newDateOfHiring) throws IOException {
		String newInfo = oldInfo;
		String oldDateOfHiring = ShowDateOfHiring();
		newInfo = newInfo.replaceAll(oldDateOfHiring, newDateOfHiring);
		fr.ChangingFile(1, oldInfo, newInfo);
		return newInfo;
	}

//	public String UpdateSubjects(String oldInfo, String newSubjects) throws IOException {
//		ArrayList newInfo = oldInfo;
//	    ArrayList oldSubjects = ShowSubjects(oldInfo);
//	    System.out.println(oldSubjects + "old" + "fff" + newSubjects + "new");
//	    newInfo.add(oldSubjects);
//	    System.out.println("G after changing: " + newInfo + "\n");
//	    fr.ChangingFile(0, oldInfo, newInfo);
//	    return newInfo;
//	}

//	
//	
//	// method to update the midterm marks
//	public String UpdateMidterm(String oldInfo, String newMidterm) throws IOException {
//	    String newInfo = oldInfo;
//	    String oldMidterm = ShowMidterm(oldInfo);
//	    newInfo = newInfo.replaceAll(oldMidterm, newMidterm);
//	    fr.ChangingFile(0, oldInfo, newInfo);
//	    return newInfo;
//	}

	// method to update the date of birth
	public String UpdateDateOfBirth(String oldInfo, String newDateOfBirth) throws IOException {
		String newInfo = oldInfo;
		String oldDateOfBirth = ShowDateOfBirth();
		newInfo = newInfo.replaceAll(oldDateOfBirth, newDateOfBirth);
		fr.ChangingFile(0, oldInfo, newInfo);
		return newInfo;
	}

	// method to update the grade
	public void UpdateGrade(String oldInfo, String newGrade) throws IOException {
		String newInfo = oldInfo;
		String oldGrade = ShowGrade();
		// System.out.println("\n"+"G before changing the grade"+G);
		System.out.println(oldGrade + "old" + "fff" + newGrade + "new");
		newInfo = newInfo.replaceAll(oldGrade, newGrade);
		System.out.println("G after changing: " + newInfo + "\n");
		fr.ChangingFile(0, oldInfo, newInfo);
	}

	// we can Change LastName and it is available for employee(s,t) ,,
	// manager(s,t,e)
	public void UpdateLastName(String oldInfo, String newLastName) throws IOException {

		String newInfo = oldInfo;
		String oldLastName = ShowLName();
//			System.out.println("\n"+"N before changing the password"+N);
		System.out.println(oldLastName + "old" + "fff" + newLastName + "new");
		newInfo = newInfo.replaceAll(oldLastName, newLastName);
		System.out.println("N after changing: " + newInfo + "\n");
		fr.ChangingFile(1, oldInfo, newInfo);

	}

	// we can Change FirstName and it is available for employee(s,t) ,,
	// manager(s,t,e)
	public void UpdateFirstName(String oldInfo, String newFirstName) throws IOException {

		String newInfo = oldInfo;
		String oldFirstName = ShowFName();
//		System.out.println("\n"+"N before changing the password"+N);
		System.out.println(oldFirstName + "old" + "fff" + newFirstName + "new");
		newInfo = newInfo.replaceAll(oldFirstName, newFirstName);
		System.out.println("N after changing: " + newInfo + "\n");
		fr.ChangingFile(1, oldInfo, newInfo);

	}

	// we can change the email and it is available for student ->manager
	public void UpdateEmail(String oldInfo, String newEmail) throws IOException {

		String newInfo = oldInfo;
		String oldEmail = ShowEmail();
//		System.out.println("\n"+"N before changing the password"+N);
		System.out.println(oldEmail + "old" + "fff" + newEmail + "new");
		newInfo = newInfo.replaceAll(oldEmail, newEmail);
		System.out.println("N after changing: " + newInfo + "\n");
		fr.ChangingFile(0, oldInfo, newInfo);

	}

	// we can change the password and it is available for student ->manager
	public void UpdatePassword(String oldInfo, String newPassword) throws IOException {

		String newInfo = oldInfo;
		String oldPassword = Showpass();
//		System.out.println("\n"+"N before changing the password"+N);
		System.out.println(oldPassword + "old" + "fff" + newPassword + "new");
		newInfo = newInfo.replaceAll(oldPassword, newPassword);
		System.out.println("N after changing the password" + newInfo + "\n");
		fr.ChangingFile(1, oldInfo, newInfo);

	}

	// we can change the number and it is available for student ->manager
	public void UpdateNumber(String oldInfo, String newNumber) throws IOException {

		String newInfo = oldInfo;
		String oldNumber = Showpass();
//		System.out.println("\n"+"N before changing the password"+N);
		System.out.println(oldNumber + "old" + "fff" + newNumber + "new");
		newInfo = newInfo.replaceAll(oldNumber, newNumber);
		System.out.println("N after changing the password" + newInfo + "\n");
		fr.ChangingFile(0, oldInfo, newInfo);

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
	// method to show the first and last name
	public void ShowName() {

		pt = Pattern.compile("Fname:" + "(\\w){2,}" + ",Lname:" + "(\\w){2,}");
		mt = pt.matcher(info);
		while (mt.find()) {

			s = mt.group();
		}
		s = s.replaceAll("Fname:", "");
		s = s.replaceAll(",Lname:", "");
		System.out.println(s);

	}

	// method to show the first name
	public String ShowFName() {

		pt = Pattern.compile("Fname:" + "(.*?)" + ",");
		mt = pt.matcher(info);
		while (mt.find()) {

			s = mt.group();
		}
		s = s.replaceAll("Fname:", ""); // Fname:
		s = s.replaceAll(",", "");
//		System.out.println(s);
		return s;

	}

	// method to show the last name
	public String ShowLName() {

		pt = Pattern.compile("Lname:" + "(.*?)" + ",");
		mt = pt.matcher(info);
		while (mt.find()) {

			s = mt.group();
		}
		s = s.replaceAll("Lname:", ""); // Fname:
		s = s.replaceAll(",", "");
//			System.out.println(s);
		return s;

	}

//   		// method to show the password
	public String Showpass() {

		pt = Pattern.compile("pass:" + "(.*?)" + ",");
		mt = pt.matcher(info);
		while (mt.find()) {

			s = mt.group();
		}
		s = s.replaceAll("pass:", "");
		s = s.replaceAll(",", "");
//		System.out.println(s);
		return s;

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.

	// method to show the number
	public String ShowNumber() {

		pt = Pattern.compile("num:" + "(.*?)" + ",");
		mt = pt.matcher(info);
		while (mt.find()) {

			s = mt.group();
		}

		s = s.replaceAll("num:", "");
		s = s.replaceAll(",", "");
//		System.out.println("your phone number is: " + s);
		return s;

	}

	// method to show the email
	public String ShowEmail() {
		pt = Pattern.compile("email:" + "(.*?)" + ",");
		mt = pt.matcher(this.info);

		while (mt.find()) {

			s = mt.group();
		}
		s = s.replaceAll("email:", "");
		s = s.replaceAll(",", "");
//		System.out.println("your phone number is:" + s);
		return s;

	}

	// method to extract the grade
	public String ShowGrade() {
		pt = Pattern.compile("grade:" + "(.*?)" + ",");
		mt = pt.matcher(this.info);
		while (mt.find()) {
			s = mt.group();
		}
		s = s.replaceAll("grade:", "");
//    s = s.replaceAll("num", "");
		s = s.replaceAll(",", "");
		// System.out.println("the grade:" + "{" + s + "}");
		return s;
	}
	/*
	 * 
	 *
	
	
		 */

	// method to show the Grade grade:2
//	public void ShowSubjects(String c) {
//		pt = Pattern.compile("subjects:" + "(.*?)" + ",");
//		mt = pt.matcher(c);
//		while (mt.find()) {
//
//			s = mt.group();
//		}
////						s = s.replaceAll("grade:", "");
////						s = s.replaceAll("num", "");
//		s = s.replaceAll(",", "");
//		System.out.println(s);
//	}

	// method to show the subjects
	public String ShowSubjects() {
		pt = Pattern.compile("subjects:" + "(.*?)" + "],");
		mt = pt.matcher(this.info);
		while (mt.find()) {
			s = mt.group();
		}
		s = s.replaceAll("subjects:", "");
		s = s.replaceAll("]", "");
		s = s.replace("[", "");
		s = s.replaceAll(",", "");

//		System.out.println( s);
		HashMap<String, Integer> map = new HashMap<>();
		String[] strArray = null;
		
		return s;
	}

	// method to show the balance
	public String Showbalance() {
		pt = Pattern.compile("balance:" + "(.*?)" + ",");
		mt = pt.matcher(this.info);
		while (mt.find()) {

			s = mt.group();
		}
						s = s.replaceAll("balance:", "");
						s = s.replaceAll(",", "");
//		System.out.println(s);
		return s;
	}

	// method to show the midterm marks {s}
	public void Showmidterm() {
		pt = Pattern.compile("midterm:" + "(.*?)" + ",");
		mt = pt.matcher(this.info);
		s = null;
		while (mt.find()) {

			s = mt.group();
		}
//						s = s.replaceAll("grade:", "");
//						s = s.replaceAll("num", "");
		s = s.replaceAll(",", "");
		System.out.println(s);
	}

	// method to show the midterm marks
//	public String ShowMidterm(String c) {
//	pt = Pattern.compile("midterm:" + "(.*?)" + ",");
//	mt = pt.matcher(c);
//	s = null;
//	while (mt.find()) {
//	s = mt.group();
//	}
//	s = s.replaceAll(",", "");
//	return s;
//	}

	// method to show the final marks {s}
	public void ShowFinal() {
		pt = Pattern.compile("Final:" + "(.*?)" + ",");
		mt = pt.matcher(this.info);
		while (mt.find()) {

			s = mt.group();
		}
//						s = s.replaceAll("grade:", "");
//						s = s.replaceAll("num", "");
		s = s.replaceAll(",", "");
		System.out.println(s);
	}

	// method to show the date of birth {s,t,e,m}
//	public void ShowDateOfBirth(String c) {
//		pt = Pattern.compile("DateOfBirth:" + "(.*?)" + ",");
//		mt = pt.matcher(c);
//		while (mt.find()) {
//
//			s = mt.group();
//		}
////						s = s.replaceAll("grade:", "");
////						s = s.replaceAll("num", "");
//		s = s.replaceAll(",", "");
//		System.out.println(s);
//	}
//
//	// method to show the date of hiring {t,e,m}
//	public void ShowDateOfHiring(String c) {
//		String g = "DateOfhiring:" + "(.*?)" + ",";
//		pt = Pattern.compile(g);
//		mt = pt.matcher(c);
//		while (mt.find()) {
//
//			s = mt.group();
//		}
//		s = s.replaceAll(",", "");
//		System.out.println(s);
//	}
	/*
	 * 
	 * 
	 *  */
	// method to show the date of birth
	public String ShowDateOfBirth() {
		pt = Pattern.compile("DateOfBirth:" + "(.*?)" + ",");
		mt = pt.matcher(this.info);
		while (mt.find()) {
			s = mt.group();
		}
		s = s.replaceAll(",", "");
		return s;
	}

	// method to show the date of hiring
	public String ShowDateOfHiring() {
		pt = Pattern.compile("DateOfhiring:" + "(.*?)" + ",");
		mt = pt.matcher(this.info);
		while (mt.find()) {
			s = mt.group();
		}
		s = s.replaceAll(",", "");
		return s;
	}

	// method to show the

	// 9900000 ahmed12021000
	// ahmed5656@gmail.com

}
