package schoolSystem;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkOperations {

	private String reciveInfo = null;
	private String[] strArray = null;
	private String s = null;
	private Pattern pt;
	private Matcher mt;
	int i = 0;
	private LinkedHashMap<String, Integer> mapOfSubjects = new LinkedHashMap<>();
	private LinkedHashMap<Integer, String> mapOfChoises = new LinkedHashMap<>();
	static Scanner input = new Scanner(System.in);
//	Pattern pt;

	Access acc = new Access();
	FileReadWrite frw = new FileReadWrite();

	public void setRecive(String reciveInfo) {
		this.reciveInfo = reciveInfo;
	}

	public LinkedHashMap<String, Integer> prepareSubjects() {
		pt = Pattern.compile("subjects:" + "(.*?)" + "],");
		mt = pt.matcher(this.reciveInfo);
		while (mt.find()) {
			s = mt.group();
		}
		s = s.replaceAll("subjects:", "");
		s = s.replaceAll("]", "");
		s = s.replace("[", "");
		s = s.replaceAll(",", "");

		strArray = s.split(" ");
		for (int i = 0; i < strArray.length; i++) {
			mapOfSubjects.put(strArray[i], 0);
		}
//		System.out.println("hii: " + map);
		return this.mapOfSubjects;
	}

	public void addUpdateMarks() throws IOException {

//		System.out.println("if you want to add marks to midterm add 1 to final add 2 ");
//		int midOrFinal = input.nextInt();
		System.out.println("chose the subjects");

		for (Map.Entry<String, Integer> e : mapOfSubjects.entrySet()) {
			System.out.println((i + 1) + ":" + e.getKey());
			mapOfChoises.put((i + 1), e.getKey());
			i++;
		}
		int[] numOfchoises = new int[i];
		Arrays.fill(numOfchoises, -1);
//		numOfchoises=takeChoises(numOfchoises);
//		for(int j=0;j<numOfchoises.length;j++)
//		{
//			System.out.println(numOfchoises[j]);
//		}
//		
//		System.out.println(this.reciveInfo);

//		if (midOrFinal == 1 || midOrFinal == 2) {
////			workMidOrFinal(midOrFinal, takeChoises(numOfchoises));
//		} else {
//			System.out.println("enter valid input please (1 or 2)");
//		}

		takeChoises(numOfchoises);

	}

	public int[] takeChoises(int numOfchoises[]) throws IOException {
		System.out.println(i);

		try {
			for (int j = 0; j < i; j++) {
				System.out.println("enter the number of the subject to stop enter out ");
				System.out.println("if want to stop enter 100");
				numOfchoises[j] = input.nextInt();
				if (numOfchoises[j] == 100) {
					numOfchoises[j] = -1;
					break;
				} else if (numOfchoises[j] > (i)) {
					System.out.println("enter a vaild input");
//						i--;
					numOfchoises[j] = -1;
				}

			}
			System.out.println("choises" + mapOfChoises);
			System.out.println("subjects" + this.mapOfSubjects);
			oldMarks();

		} catch (NumberFormatException e) {
			System.out.println("Invalid numbers. Please enter a valid number.");
		}

		return numOfchoises;
	}

	public LinkedHashMap<String, Integer> workMidOrFinal(int midOrFinal, int[] numOfchoises) throws IOException {

		int j = 0;
		while (numOfchoises[j] != -1) {
			System.out.println("enter the mark of " + mapOfChoises.get(numOfchoises[j]));
			int markis = input.nextInt();
			mapOfSubjects.put(mapOfChoises.get(numOfchoises[j]), markis);
			j++;
		}
//		System.out.println(this.mapOfSubjects);
//		System.out.println(this.mapOfChoises);

		String newInfo = this.reciveInfo;
		Pattern oldmarks = null;
		String newMarks = null;
		if (midOrFinal == 1) {

			pt = Pattern.compile("midterm:" + "(.*?)" + "},");
			mt = pt.matcher(this.reciveInfo);
			newMarks = "midterm:" + this.mapOfSubjects.toString();
		} else {

			pt = Pattern.compile("Final:" + "(.*?)" + "},"); // "Final:{null}";
			mt = pt.matcher(this.reciveInfo);
			newMarks = "Final:" + this.mapOfSubjects.toString();
		}
		while (mt.find()) {

			s = mt.group();
		}
// pt = Pattern.compile("Fname:" + "(.*?)" + ",");
		System.out.println("\n" + "G before changing the grade" + newInfo);
		System.out.println(oldmarks + "old" + "fff" + newMarks + "new");
//		String
		newInfo = this.reciveInfo.replace(s, newMarks);
		System.out.println("G after changing: " + newInfo + "\n");
//		frw.ChangingFile(0, this.reciveInfo, newInfo);

		return this.mapOfSubjects;
	}

	public void oldMarks() { //int midOrFinal
		
		pt = Pattern.compile("midterm:" + "(.*?)" + "},");
		mt = pt.matcher(this.reciveInfo);
		
		while (mt.find()) {

			s = mt.group();
		}
       if(s.equals("midterm:{null},")==false){
    	   
       }
       
       System.out.println(s);
	}








}
