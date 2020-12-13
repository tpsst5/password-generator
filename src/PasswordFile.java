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
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class PasswordFile {
	private String txtFile;
	
	
	public PasswordFile() {
		this.txtFile = "passwords.txt";
	}
	
	public void addPassword(String label, String password) {
		try (FileWriter fw = new FileWriter(this.txtFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);) {
			
			pw.println(label + ": " + password);
			System.out.println("New password added to existing file.");
			
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	public void listPasswords () {
		try (Scanner scanner = new Scanner(Paths.get(this.txtFile))) {
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
		try (Scanner scanner = new Scanner(Paths.get(this.txtFile))) {
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
		File oldFile = new File(this.txtFile);
		File temp = new File("temp.txt");
		Scanner scanner = new Scanner(System.in);
		
		try (Scanner fileScanner = new Scanner(Paths.get(this.txtFile));
				FileWriter fw = new FileWriter(temp, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);) {
			while (fileScanner.hasNextLine()) {
				String row = fileScanner.nextLine();
				// Check if current row contains the input label
				if (row.contains(label)) {
					System.out.print("Delete " + row + " (y/n)? ");
					String answer = scanner.nextLine();
					// Copy current line into temp file if current isn't to be deleted
					if (answer.equals("n")) {
						pw.println(row);
					} else {
						System.out.println(row + " deleted.");
					}
				} else {
					pw.println(row);
				}
			}
			
		} catch (IOException i) {
			i.printStackTrace();
		}			
		
		oldFile.delete();
		File dump = new File(this.txtFile);
		temp.renameTo(dump);
		scanner.close();
	}
}
