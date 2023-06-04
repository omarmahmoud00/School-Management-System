package schoolSystem;

import java.io.IOException;

public class Manager extends Teacher {
	private int ManagerId;
	private String password;

	//private static int id = 1100;

	public Manager(String FirstName, String lastName, String number, String email, double Balance, String DateOfBirth,
			String DateOfhiring) throws IOException {
		super(FirstName, lastName, number, email, Balance, DateOfBirth, DateOfhiring);
		this.password = frw.SettingPassword(getFirstName(), getDateOfBirth());
		this.ManagerId = frw.SettingId(3);
	}

	// toString
	public String toString() {
		return "ID:" + this.ManagerId + "," + "pass:" + this.password + "," + "Fname:" + getFirstName() + "," + "Lname:"
				+ getLastName() + "," + "num:" + getNumber() + "," + "email:" + getEmail() + "," + "DateOfBirth:"
				+ getDateOfBirth() + "," + "DateOfhiring:" + "," + getDateOfHiring() + "balance:" + getBalance() + ",";
	}

	// writing from file
	public void writeToFile() {
		frw.writingFile(toString(), 3);
	}

//	public void setPassword() {
//		FileReadWrite frw = new FileReadWrite();
//		this.password =frw.settingPassword(this.Fname, this.DateOfBirth);
//	}

}
