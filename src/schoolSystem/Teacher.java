package schoolSystem;

import java.io.IOException;
import java.util.ArrayList;

public class Teacher extends Person {

	private int TeacherId;
	private String password;
	private String DateOfHiring;
//	private static int Id = 330000;
	private double Salary = 2000;
	private String Grade;
	private ArrayList<String> Subjects;

	public Teacher(String firstName, String lastName, String number, String email, double Balance, String dateOfBirth,
			String DateOfhiring) throws IOException {
		// super();
		super(firstName, lastName, number, email, dateOfBirth, Balance);
		this.DateOfHiring = DateOfhiring;
		this.password = frw.SettingPassword(getFirstName(), getDateOfBirth());
		this.TeacherId = frw.SettingId(1);

	}

	public String getDateOfHiring() {
		return this.DateOfHiring;
	}

	public void setDateOfHiring(String dateOfhiring) {
		this.DateOfHiring = dateOfhiring;
	}

	public String getGrade() {
		return this.Grade;
	}

	public void setGrade(String grade) {
		this.Grade = grade;
	}

	public ArrayList<String> getSubjects() {
		return this.Subjects;
	}

	public void setSubjects(String subjects) {
		this.Subjects.add(subjects);
	}

	// toString
	public String toString() {
		return "ID:" + this.TeacherId + "," + "pass:" + this.password + "," + "Fname:" + getFirstName() + "," + "Lname:"
				+ getLastName() + "," + "grade:" + this.Grade + "," + "num:" + getNumber() + "," + "email:" + getEmail()
				+ "," + "DateOfBirth:" + getDateOfBirth() + "," + "subjects:{" + this.Subjects + "}," + "DateOfhiring:"
				+ this.DateOfHiring + "," + "balance:" + getBalance() + ",";
	}

	// writing from file

	public void writeToFile() throws IOException {
		frw.writingFile(toString(), 1);
	}

}
