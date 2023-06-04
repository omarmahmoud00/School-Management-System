package schoolSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BalanceOperations {

	public String getReciveInfo() {
		return reciveInfo;
	}

	public void setReciveInfo(String reciveInfo) {
		this.reciveInfo = reciveInfo;
	}

	private String reciveInfo = null;
	private String[] strArray = { "Art", "swiming", "music" };
	private String s = null;
	private Pattern pt;
	private Matcher mt;
	private int j = 0, type = 0;
	private double balance = 0; // Math English history science
	private LinkedHashMap<String, Integer> mapOfSubjects = new LinkedHashMap<>();
	static Scanner input = new Scanner(System.in);
	Access acc = new Access();
	FileReadWrite frw = new FileReadWrite();
	GeneralOperations Go = new GeneralOperations();
	ArrayList<String> Subjects = new ArrayList<String>();

	public void setType(int type) {
		this.type = type;
	}

	/*
	 * in this method a add and delete subjects . 1* in first part a read the
	 * subjects and and them to arraylist the main subjects are 4 so if the user
	 * have more than 4 he can delete any of them 2* the user can add new optional
	 * subjects but if the subjects are 7(the mani 4 + optional 3 ),he can not add
	 * any more if the user have the subject before he cant add it one more time 3*
	 * it counts the balance by knowing the number of subjects it changes the
	 * subjects to the new ones . the reciveinf will change to the new one t it
	 * calls the updatebalace to add the new balance to file
	 * 
	 */
	public void addDeleteOptionalSubjects() throws IOException {
		Go.setInfo(reciveInfo);
//	    this.balance=Go.Showbalance();

		pt = Pattern.compile("subjects:" + "(.*?)" + "],");
		mt = pt.matcher(this.reciveInfo);
		while (mt.find()) {
			s = mt.group();
		}

		s = s.replaceAll("subjects:", "");
		String oldSubjects = s.replaceAll("],", "]");
//		System.out.println(oldSubjects + "the first");
		s = s.replaceAll("],", "");
		s = s.replace("[", "");
//		s = s.replaceAll(",", "");
		s.replaceAll(",", "");
		s.replaceAll(" ", "");

//		System.out.println(s + "the second"); 

		String[] array = s.replaceAll(",", "").split(" ");
		for (int i = 0; i < array.length; i++) {
			Subjects.add(array[i]);
//			System.out.println("your subjectes are: " + array[i] );
		}
//		System.out.println("your subjectes are: " + Subjects.size() );

		if (this.Subjects.size() > 4) {
			System.out.println("your subjects are" + Subjects);
			System.out.println("do you want delete any of optional subjects ?. if yes enter y n for no");
			String yesorno = input.next();
			if (yesorno.equals("y")) {
				for (int i = 4; i <= this.Subjects.size(); i++) {
					System.out.println("enter " + (i) + "for" + this.Subjects.get(i)
							+ " to go to next subject enter 0. for exit enter 100");
					int opt = input.nextInt();
					if (opt == 100)
						break;
					if (opt != 0) {
						this.Subjects.remove(this.Subjects.get(i));
					}
				}
				;
			}
		}
		int sizeOfSubjects = this.Subjects.size();
		if (this.Subjects.size() != 7) {
			for (int i = 0; i < strArray.length; i++) {
				System.out.println("if you want add " + strArray[i] + " enter: " + (i + 1)
						+ " if you want to go to next subject enter 0 " + "for exit enter 100");
				j = input.nextInt();

				if (j == 100)
					break;
				if (j >= 1 && j <= 3) {
					if (this.Subjects.contains(this.strArray[(j - 1)]) == false) {
						this.Subjects.add(this.strArray[(j - 1)]);
					} else {
						System.out.println(this.strArray[(j - 1)] + "is in your subjects");
					}

				} else if (j == 0) {

				} else {
					System.out.println("your entered a wrong input");
				}
			}

			this.balance = ((Subjects.size() - 4) * 300) + 6000;
			String newInfo = this.reciveInfo;
			String oldSub = oldSubjects;
			System.out.println(oldSubjects + "old" + "fff" + this.Subjects.toString() + "new");
			newInfo = newInfo.replace(oldSubjects, this.Subjects.toString());
			System.out.println("N after changing: " + newInfo + "\n");
			frw.ChangingFile(this.type, this.reciveInfo, newInfo);
			this.reciveInfo = newInfo;

		}

		UpdateBalance();
	}

	public void UpdateBalance() throws IOException {

		System.out.println("UpdateBalance");
		Go.setInfo(reciveInfo);
		String newInfo = this.reciveInfo;
		String oldBalance = Go.Showbalance();
		System.out.println("\n" + "N before changing the password" + oldBalance);
		System.out.println("new balance edition");
//		double newBanlace = countIncrDec();
//		System.out.println(oldBalance + "old" + "fff" + newBanlace + "new");
		newInfo = newInfo.replaceAll(oldBalance, Double.toString(this.balance));
		System.out.println("N after changing: " + newInfo + "\n");
		frw.ChangingFile(this.type, this.reciveInfo, newInfo);

	}

	// method to count the days of teacher ,employee and managers which they off and
	// for extra money and rewrite the balance to the file
	public void countIncrDec() throws IOException {

		System.out.println("enter the days off: ");
		double decrement = input.nextDouble();
		System.out.println("enter  extra money ");
		double extra = input.nextDouble();
//     
		this.balance = Double.parseDouble(Go.Showbalance()) + ((decrement * -1 * 50) + extra);
//		return this.balance;
		System.out.println("UpdateBalance");
		Go.setInfo(reciveInfo);
		String newInfo = this.reciveInfo;
		String oldBalance = Go.Showbalance();
		System.out.println("\n" + "N before changing the password" + oldBalance);
		System.out.println("new balance edition");
		newInfo = newInfo.replaceAll(oldBalance, Double.toString(this.balance));
		System.out.println("N after changing: " + newInfo + "\n");
		frw.ChangingFile(this.type, this.reciveInfo, newInfo);

	}

}
