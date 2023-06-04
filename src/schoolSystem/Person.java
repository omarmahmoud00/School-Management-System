package schoolSystem;

public class Person {
	//private String Password;
	private String FirstName;
	private String LastName;
	private String Number;
	private String Email;
	private String DateOfBirth;
	private double Balance = 2000;
	FileReadWrite frw = new FileReadWrite();
	public Person(String firstName, String lastName,  String number, String email, String dateOfBirth,double Balance) {
		super();
		this.Balance= Balance;
		FirstName = firstName;
		LastName = lastName;
		Number = number;
		Email = email;
		DateOfBirth = dateOfBirth;

	}
	public Person() {}

	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	
}
