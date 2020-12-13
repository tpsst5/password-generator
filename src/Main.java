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
		PasswordFile file = new PasswordFile();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("PASSWORD GENERATOR");
		System.out.println();
		
		System.out.println("Commands:");
		System.out.println("new - generates new password");
		System.out.println("search - searches for existing password");
		System.out.println("delete - deletes searched item");
		System.out.println("list - lists all passwords");
		System.out.println("quit - exists program");
		
		System.out.println();
		System.out.print("Command? ");
		String command = scanner.nextLine();
		
		if (command.toLowerCase().equals("new")) {
			PasswordUI passwordUI = new PasswordUI();
			passwordUI.startUI();
		} else if (command.toLowerCase().equals("search")) {
			System.out.print("Label/keyword password is stored with? ");
			String label = scanner.nextLine();
			System.out.println();
			file.findPassword(label);
		} else if (command.toLowerCase().equals("delete")) {
			System.out.print("Password to delete? ");
			String inputLabel = scanner.nextLine();
			System.out.println();
			file.deletePassword(inputLabel);
		} else if (command.toLowerCase().equals("list")) {
			System.out.println();
			System.out.println("Passwords:");
			file.listPasswords();
		} else if (command.toLowerCase().equals("quit")) {
			System.out.println("Exiting program");
		} else {
			System.out.println("Invalid command");
		}
		
		scanner.close();
	}
}
