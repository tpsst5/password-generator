/**
 * 	Generate password based on user inputs
 */
		
/**
 * @author Tim Shea
 *
 */
import java.util.Random;

public class Password {
	private int length;
	private boolean uppercase;
	private boolean lowercase;
	private boolean digits;
	private boolean characters;
	
	Random random = new Random();
	
	public Password(int len, boolean upper, boolean lower, boolean digits, boolean characters) {
		this.length = len;
		this.uppercase = upper;
		this.lowercase = lower;
		this.digits = digits;
		this.characters = characters;
	}
	
	public String generatePassword() {
		String password = "";
		
		while (password.length() < this.length) {
			// Check for each password trait and add a random character to the password
			if (this.uppercase && password.length() < this.length) {
				password += getUppercase();
			}
			
			if (this.lowercase && password.length() < this.length) {
				password += getLowercase();
			}
			
			if (this.digits && password.length() < this.length) {
				password += getDigits();
			}
			
			if (this.characters && password.length() < this.length) {
				password += getCharacters();
			}
		}
		
		return password;
	}
	
	public String getUppercase() {
		
		char uppercaseLetter = (char) (random.nextInt(25) + 66);
		return String.valueOf(uppercaseLetter);
	}
	
	public String getLowercase() {
		
		char lowercaseLetter = (char) (random.nextInt(25) + 98);
		return String.valueOf(lowercaseLetter);
	}
	
	public String getDigits() {
		
		int digit = random.nextInt(10);
		return String.valueOf(digit);
	}
	
	public String getCharacters() {
		
		char character = (char) (random.nextInt(15) + 33);
		
		return String.valueOf(character);
	}
}
