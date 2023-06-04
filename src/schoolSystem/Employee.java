package schoolSystem;

import java.io.IOException;

public class Employee extends Teacher {

	private int EmployeeId;
	private String Password;
//	private static int Id = 22000;

	public Employee(String FirstName, String lastName, String number, String email, double Balance, String DateOfBirth,
			String DateOfhiring) throws IOException {
		super(FirstName, lastName, number, email, Balance, DateOfBirth, DateOfhiring);
		this.EmployeeId = frw.SettingId(2);
		this.Password = frw.SettingPassword(getFirstName(), getDateOfBirth());

	}

	// toString
	public String toString() {
		return "ID:" + this.EmployeeId + "," + "pass:" + this.Password + "," + "Fname:" + getFirstName() + ","
				+ "Lname:" + getLastName() + "," + "," + "num:" + getNumber() + "," + "email:" + getEmail() + ","
				+ "DateOfBirth:" + getDateOfBirth() + "," + "DateOfhiring:" + "," + getDateOfHiring() + "," + "balance:"
				+ getBalance() + ",";
	}

	// writing from file
	public void writeToFile() {
		frw.writingFile(toString(), 2);
	}

}
