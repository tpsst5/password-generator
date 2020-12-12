/**
 * 
 */

/**
 * @author Tim Shea
 *
 */
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PasswordFile {
	private String csvFile;
	
	
	public PasswordFile() {
		this.csvFile = "passwords.txt";
	}
	
	public void addPassword(String label, String password) {
		try (FileWriter fw = new FileWriter(this.csvFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);) {
			
			pw.println(label + ": " + password);
			System.out.println("New password added to existing file.");
			
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	public void listPasswords () {
		try (Scanner scanner = new Scanner(Paths.get(this.csvFile))) {
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				System.out.println(row);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void findPassword (String label) {
		System.out.println("Search results:");
		try (Scanner scanner = new Scanner(Paths.get(this.csvFile))) {
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				// Check if current row contains the input label
				if (row.contains(label)) {
					System.out.println(row);
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}		
	}
	
	public void deletePassword (String label) {
		try (Scanner scanner = new Scanner(Paths.get(this.csvFile))) {
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				// Check if current row contains the input label
				if (row.contains(label)) {
					System.out.println("Delete " + row + " (y/n)?");
					String answer = scanner.nextLine();
					if (answer.equals("y")) {
						// remove row  ADDD THISS LAATTERRRRRR!!!!!!
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}			
	}
}
