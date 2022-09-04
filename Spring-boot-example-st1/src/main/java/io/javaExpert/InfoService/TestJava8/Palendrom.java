package io.javaExpert.InfoService.TestJava8;

public class Palendrom {

	public static void main(String[] args) {

		String original = "Madam";
		String future = "";
		for (int i = 0; i < original.length(); i++) {
			future = original.charAt(i) + future;
		}
		if (original.equalsIgnoreCase(future)) {
			System.out.println("Given String is Palendrom!");
		} else
			System.out.println("Given String is Not  Palendrom!");

		StringBuffer sb = new StringBuffer();
		sb.append(original);
		String str = sb.reverse().toString();

		if (str.equalsIgnoreCase(original)) {
			System.out.println("Given String is Palendrom");
		} else
			System.out.println("Given String is Not  Palendrom");

	}

}
