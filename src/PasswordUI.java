/**
 * 	UI for generating a new password
 */

/**
 * @author Tim Shea
 *
 */
import java.util.Scanner;


public class PasswordUI {
	private Scanner scanner;
	
	/**
	 * 
	 */
	public PasswordUI() {
		this.scanner = new Scanner(System.in);
	}
	
	public void startUI() {
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
					System.out.println();
					System.out.println("Invalid input");
					this.startUI();
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
					System.out.println();
					System.out.println("Invalid input");
					this.startUI();
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
					System.out.println();
					System.out.println("Invalid input");
					this.startUI();
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
					System.out.println();
					System.out.println("Invalid input");
					this.startUI();
					break;
				}
				
				// Check to see if no inputs were selected
				if (uppercase == false && lowercase == false && digits == false && specialChars == false) {
					System.out.println();
					System.out.println("At least one password requirement needed.");
					this.startUI();
					break;
				}
				
				System.out.println();
				
				// Generate new password
				Password passwordVariables = new Password(length, uppercase, lowercase, digits, specialChars);
				String password = passwordVariables.generatePassword();
				System.out.println("Your new password is: " + password);
				System.out.println();
				
				System.out.print("Password label? ");
				String label = scanner.nextLine();  
				
				// Add new password to existing .txt file
				PasswordFile file = new PasswordFile();
				file.addPassword(label, password);
				
				scanner.close();
				break;
				
			} catch(Exception e) {
				System.out.println();
				System.out.println("Invalid input.");
				this.startUI();
				break;
			}
			
		}
	}
}
