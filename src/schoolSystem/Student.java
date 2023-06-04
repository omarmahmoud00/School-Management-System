package schoolSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student extends Person {

	Scanner in = new Scanner(System.in);

	private int StudentId;
	private String Password;
//	private static int Id = 9900000;
	private String Grade;
	private String MidTerm;
	private String Final;
//	private Map<String, Integer>  Subjects = new HashMap<>(); 
  
	ArrayList<String> Subjects = new ArrayList<String>();


	public Student(String firstName, String lastName, String number, String email, String dateOfBirth, double Balance)
			throws IOException {
		super(firstName, lastName, number, email, dateOfBirth, Balance);
		this.Password = frw.SettingPassword(getFirstName(), getDateOfBirth());
		this.StudentId = frw.SettingId(0);
//		Map<String, Integer> Subjects = new HashMap<>();
//		TheSujects();
	}

	public Student() throws IOException {
		super();
		this.Password = frw.SettingPassword(getFirstName(), getDateOfBirth());
		this.StudentId = frw.SettingId(0);
		TheSujects();

	}

	public void TheSujects() {
		Subjects.add("Math");
		Subjects.add("English");
		Subjects.add("history");
		Subjects.add("science");
	}
//ArrayList<String>
	public ArrayList<String> getSubjects() {
		return this.Subjects;
	}

	public void setSubjects(String subjects) {
		this.Subjects.add(subjects);
	}

	public String getGrade() {
		return this.Grade;
	}

	public void setGrade(String grade) {
		this.Grade = grade;
	}

	public String getMidTerm() {
		return this.MidTerm;
	}

	public void setMidTerm(String midTerm) {
		this.MidTerm = midTerm;
	}

	public String getFinal() {
		return Final;
	}

	public void setFinal(String final1) {
		this.Final = final1;
	}
//public String enrollSubjects() {
//	
//}
	// toString
	public String toString() {
		return "ID:" + this.StudentId + "," + "pass:" + this.Password + "," + "Fname:" + getFirstName() + "," + "Lname:"
				+ getLastName() + "," + "grade:" + this.Grade + "," + "num:" + getNumber() + "," + "email:" + getEmail()
				+ "," + "DateOfBirth:" + getDateOfBirth() + "," + "subjects:" + this.Subjects + "," + "midterm:{"
				+ this.MidTerm + "}," + "Final:{" + this.Final + "}," + "balance:" + getBalance() + ",";
	}

	// writing into file
	public void writeToFile() throws IOException {

		frw.writingFile(toString(), 0);

	}

}
