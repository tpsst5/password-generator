/**
 * 	Command line tool to generate and save new passwords
 */

/**
 * @author Tim Shea
 *
 */

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("PASSWORD GENERATOR");
		System.out.println();
		
		while (true) {
			try {
				System.out.println("Enter to start...");
				if (scanner.nextLine().equals("exit")) break;
				
				// Get length of password
				System.out.print("Password length?(5 - 20 characters) ");
				int length = Integer.parseInt(scanner.nextLine());
				
				if (length < 5 || length > 20) {
					System.out.println("Pick length from 5 to 20");
					System.out.println();
					continue;
				}
				
				// Get uppercase letter requirement choice
				System.out.println();
				System.out.print("Uppercase letters needed(y/n)? ");
				String response = scanner.nextLine();
				boolean uppercase;
				
				if (response.equals("y")) {
					uppercase = true;
				} else if (response.equals("n")) {
					uppercase = false;
				} else {
					System.out.println("Invalid input");
					break;
				}
				
				// Get lowercase letter requirement choice
				System.out.println();
				System.out.print("Lowercase letters needed(y/n)? ");
				response = scanner.nextLine();
				boolean lowercase;
				
				if (response.equals("y")) {
					lowercase = true;
				} else if (response.equals("n")) {
					lowercase = false;
				} else {
					System.out.println("Invalid input");
					break;
				}
				
				// Get digits requirement choice
				System.out.println();
				System.out.print("Digits (1 - 9) needed(y/n)? ");
				response = scanner.nextLine();
				boolean digits;
				
				if (response.equals("y")) {
					digits = true;
				} else if (response.equals("n")) {
					digits = false;
				} else {
					System.out.println("Invalid input");
					break;
				}
				
				// Get special characters requirement choice
				System.out.println();
				System.out.print("Special characters (!, %, $, #, etc.) needed(y/n)? ");
				response = scanner.nextLine();
				boolean specialChars;
				
				if (response.equals("y")) {
					specialChars = true;
				} else if (response.equals("n")) {
					specialChars = false;
				} else {
					System.out.println("Invalid input");
					break;
				}
				
				System.out.println();
				scanner.close();
				
				// Generate new password
				Password password = new Password(length, uppercase, lowercase, digits, specialChars);
				System.out.println("Your new password is: " + password.generatePassword());
				break;
				
			} catch(Exception e) {
				System.out.println();
				System.out.println("Invalid input. Exiting program.");
				break;
			}
			
			
		}
	}
}
