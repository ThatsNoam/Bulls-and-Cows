package January;

import java.util.Scanner;

public class BulPgia {
  public static String randomString() {
		String secretCode =  "";
		for (int i =1;i<=4;i++) {
			 int rand = (int)(Math.random() * 9-0) + 0;
			 char randChar = (char)rand;
			 randChar += '0';
			 secretCode += "" + randChar ;
		}
		return secretCode;	  
  }

	  
  
  public static void main(String[] args) {
	 String secretCode = randomString();
    int guesses = 0;
    Scanner scan = new Scanner(System.in);
    
    while (true) {
      System.out.print("Enter a 4-digit guess: ");
      String guess = scan.nextLine();

      if (guess.matches("[0-9]{4}")) {
    	int bulls = 0;
        int notbulls = 0;

        String feedback = "";

        for (int i = 0; i < 4; i++) {
          if (secretCode.charAt(i) == guess.charAt(i)) {
            bulls++;
            feedback += "*";
          }
          else if (secretCode.contains(String.valueOf(guess.charAt(i)))) {
        	notbulls++;
            feedback += "O";
          }
          else {
            feedback += "-";
          }
        }

        System.out.print("Feedback: ");
        for (int i = 0; i < feedback.length(); i++) {
          System.out.print(feedback.charAt(i));
          if (i < feedback.length() - 1) {
            System.out.print(" ");
          }
        }
        System.out.println();

        if (bulls == 4) {
          System.out.println("Congratulations! You cracked the code in " + (guesses+1) + " guesses.");
          break;
        }
                guesses++;

        if (guesses == 10) {
          System.out.println("You have reached the maximum number of guesses. The code was: " + secretCode);
          break;
        }
      } else {
        System.out.println("Invalid guess. Please enter a 4-digit number.");
      }
    }
  }
}

	