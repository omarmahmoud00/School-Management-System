package schoolSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class FileReadWrite {

	// method to write the new object into the file
	public void writingFile(String info, int i) {
		try {
			FileWriter writer1 = new FileWriter("stud.txt", true);
			FileWriter writer2 = new FileWriter(("TCH.txt"), true);
			FileWriter writer3 = new FileWriter(("EMPFile.txt"), true);
			FileWriter writer4 = new FileWriter(("MNGFile.txt"), true);
			FileWriter writer[] = { writer1, writer2, writer3, writer4 };
			BufferedWriter wr = new BufferedWriter(writer[i]);
			writer[i].write(info.toString() + "\n");

			writer[i].close();
			System.out.println(info);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// method to read from the file. type represents the kind of the file is it to
	// student ,teacher...etc
	public static String ReadingFile(int type) throws IOException {
		String search = null;
		String found = "null";
		try {

			BufferedReader read1 = new BufferedReader(new FileReader("stud.txt"));
			BufferedReader read2 = new BufferedReader(new FileReader("TCH.txt"));
			BufferedReader read3 = new BufferedReader(new FileReader("EMPFile.txt"));
			BufferedReader read4 = new BufferedReader(new FileReader("MNGFile.txt"));
			BufferedReader[] read = { read1, read2, read3, read4 };

			while ((search = read[type].readLine()) != null) {
				found = search;
			}
			read[type].close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;
	}

//  changing the information of specific line in the file 	
	public static void ChangingFile(int filetype, String oldLine, String newLine) throws IOException {

		String search = null;
		String found = "";
		ArrayList<String> stringList = new ArrayList<String>();
		String fileName = null;

		switch (filetype) {

		case 0:
			fileName = "stud.txt";
			break;
		case 1:
			fileName = "TCH.txt";
			break;
		case 2:
			fileName = "EMPFile.txt";
			break;
		case 3:
			fileName = "MNGFile.txt";
			break;
		}

//		System.out.println("in changing file :" + newLine);
//		System.out.println("in changing file :" + oldLine);
		try {

			BufferedReader read = new BufferedReader(new FileReader(fileName));
			System.out.println("printing the file line by line");
			while ((search = read.readLine()) != null) {

//				 found +="\n";
				if (search.equals(oldLine))
					stringList.add(newLine);
//				 found += search;
				else
					stringList.add(search);
//				 System.out.println("in the loop");

//				 System.out.println(search);

//				 content.append(search);
//	                content.append(System.lineSeparator());
			}
			read.close();
			System.out.println("the end of the file");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println(stringList.isEmpty());

		FileWriter writer = new FileWriter(fileName);
		writer.write("");
		try {
			BufferedWriter wr = new BufferedWriter(writer);
			for (String element : stringList) {
				writer.write(element + "\n");
			}
			writer.close();
			System.out.println("ArrayList written to file.");
		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// method to set id to student,teacher,employee and manager
	/*
	 * method take two parameter j=>refer to which class (student or teacher...etc)
	 * the second one(patt) is the pattern of the id which is unique for each class
	 */
	public int SettingId(int j) throws IOException {
		int i = 0;
		String pat;
		try {
			if (j == 0) {
				pat = "((99)+[\\d]{5})";

			} else if (j == 1) {
				pat = "((33)+[\\d]{4})";

			} else if (j == 2) {
				pat = "((22)+[\\d]{3})";

			} else {
				pat = "((11)+[\\d]{2})";

			}

			Pattern pt = Pattern.compile(pat);
			Matcher mt = pt.matcher(ReadingFile(j));

			while (mt.find()) {
				i = Integer.parseInt((mt.group()).toString());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (i == 0) {
			if (j == 0) {
				return 9900000;

			} else if (j == 1) {
				return 330000;

			} else if (j == 2) {
				return 22000;

			} else {
				return 1100;

			}

		} else {
			return i + 1;
		}

	}

	public String SettingPassword(String name, String dateOfBirth) {
		return name + dateOfBirth.replace("/", "");
	}

}
