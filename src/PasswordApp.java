import java.util.Scanner;

/**
 * Main class for the password app that allows the user to create 
 * auto-generated passwords and save them in a text file. User can also 
 * search, edit, list, and delete existing passwords.
 * 
 * Password Generator App - PasswordApp.java
 * @author Tim Shea
 * @version 2/22/2021
 **/
public class PasswordApp {

   /**
    * Main driver method for Password App.
    *
    * @param args - not used
    **/
	public static void main(String[] args) {
		PasswordFile file = new PasswordFile();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("PASSWORD GENERATOR\n");
		
		System.out.println("Commands:");
		System.out.println("new - generates new password");
		System.out.println("search - searches for existing password");
		System.out.println("delete - deletes searched item");
		System.out.println("list - lists all passwords");
		System.out.println("quit - exists program\n");
		
		System.out.print("Command: ");
		String command = scanner.nextLine();
		
		if (command.toLowerCase().equals("new")) {
			PasswordUI passwordUI = new PasswordUI();
			passwordUI.startUI();
		} else if (command.toLowerCase().equals("search")) {
			System.out.print("Label/keyword password is "
               + "stored with? ");
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
