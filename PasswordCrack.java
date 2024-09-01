package passwordCracker;
import java.util.*;
import java.io.*;

public class PasswordCrack {
	
	private static int attempts;
	private static boolean foundPass;
	
	public PasswordCrack(int attempts, boolean foundPass) {
		this.attempts = attempts;
		this.foundPass = foundPass;
	}
	
	public static int getAttempts() {
		return attempts;
	}
	
	public static boolean getIsFound() {
		return foundPass;
	}
	
	public static PasswordCrack isFound(String password, Scanner passwords) {
		
		int attemptCount = 0;
		boolean found = false;
		
		while(passwords.hasNextLine()) {
			String currentPass = passwords.nextLine();
			if (password.equals(currentPass)) {
				attemptCount++;
				found = true;
				break;
			} else {
				System.out.println(currentPass);
				attemptCount++;
			}
				
		}
		
		return new PasswordCrack(attemptCount, found);
	}

	public static void main(String[] args) throws IOException {
		
		Scanner passwords = new Scanner(new File("MostCommonPasswords.txt"));
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Password: ");
		String password = userInput.next();
		
		isFound(password, passwords);
		
		if(getIsFound() == true) {
			System.out.println("Your password was guessed after: " + getAttempts() + " attempts.");
		} else {
			System.out.println("Your password could not be breached!");
		}
		
		

	}

}
