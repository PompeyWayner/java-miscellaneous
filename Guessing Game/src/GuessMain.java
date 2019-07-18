// Main control program to play word guessing game
import java.io.*;


import java.util.*;

public final class GuessMain {
	
	// Method - Returns random string from ArrayList
	 public static String getWord(List<String> w) {
		Random rWord = new Random();
		
		String r = w.get(rWord.nextInt(w.size()));
		return r;
	}
	
	// Main program loop
	public static void main(String[] args) {
		
		// ArrayList stores the words from the file
		List<String> words = new ArrayList<String>();
		String word; 			// Stores read word from file		
		char again = 'y';   	// Holds result of new game
		String currentGuess;	// Stores current guess string
		char newLetter = '*'; 	// Stores current letter guess
		String newWord;			// Holds current word to be guessed
		
		// Open input file of words to be read
		try (BufferedReader wordsFile = new BufferedReader
				(new FileReader("C:\\Users\\wsand\\Documents\\JAVA\\Guessing Game\\src\\test.txt"))) {
			while((word = wordsFile.readLine()) != null ) {			
				words.add(word.toUpperCase()); // add file word to ArrayList			 
			}
		} catch(IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
		
		//System.out.println(words); // test to see if all words read in
		
		do {
			
			// Generates random string using ArrayList of words - test
			// change to get random word			
			newWord = getWord(words);
			//System.out.println("*** Random word is " + newWord); // test show random word
			
			System.out.println("Guess the word game\n");
			// Play the game with selected random word
			System.out.println("The word is " + newWord.length() + " letters long");
			// Create new game object
			GuessWordGame newGame = new GuessWordGame(newWord);
			currentGuess = newGame.getCurrentWord(); // Initiaise empty word
			System.out.println(currentGuess);   // Display empty word
			
			// Loop for entering letters
			do {
				
				// Enter letter
				try {
					System.out.print("\nEnter a letter : ");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					newLetter = (char) br.read();
				} catch(IOException exc) {
					System.out.println("Input Exception Error");
				}
				
				// Check to see if letter in word and update
				currentGuess = newGame.checkLetter(newLetter, currentGuess);
				System.out.println(currentGuess);
				newGame.lettersUsed(); // Display letters used
				// Display lives left
				System.out.println("You have " + newGame.livesLeft() + " lives left");
				// Break out of game if out of lives
				if (newGame.livesLeft() == 0) {
					System.out.println("Bad luck you ran out of guesses!!!");
					System.out.println("The word was " + newWord);
					break;
				}
				// Well done word guessed
				if (newGame.getWordCount() == newWord.length()) {
					System.out.println("Well Done!! you guessed the word");
				}
					
			  // Perform while word has not be guessed
			} while( newWord.length() != newGame.getWordCount());
			
			// New game input`
			try {			
				
				System.out.print("Do you want to play again? (y/n) : ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				again = (char) br.read();
			} catch(IOException exc) {
				System.out.println("Another game error " + exc);
			}
			
			// Test for invalid input for another game
			if(again != 'y' && again != 'Y' && again != 'n' && again != 'N') {
				System.out.println("Invalid Selection !!!");
				again = 'y';
			}
			
			System.out.println("\n\n\n");

		} while(again == 'y'|| again == 'Y');
		
		// Goodbye message
		System.out.println("Goodbye...");
	}

}