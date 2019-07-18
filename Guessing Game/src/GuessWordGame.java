// Guess the word class - used with GuessMain
import java.util.ArrayList;
import java.util.List;

public class GuessWordGame {

	private String wordToGuess;
	private String currentWord;
	private int wordCount;
	private boolean letterFound;
	private int live;
	private List<Character> usedLetters = new ArrayList<>(); // Holds guessed letters
	private boolean firstTime;
	
	// Constructor
	public GuessWordGame(String w) {		
		wordToGuess = w; // Random word to be guessed
		currentWord = setWordLength(wordToGuess);
		wordCount = 0; // Keep account for number letters guessed so far
		letterFound = false; 
		live = 0; // Keeps count of lives used
		firstTime = true; // Duplicate will be called once this is false
	}
	
	// Method - Getter for private currentWord String
	public String getCurrentWord() {
		return currentWord;
	}
	
	// Method - Getter for private wordCount variable
	public int getWordCount() {
		return wordCount;
	}
	
	// Method - Initialise string length of random word to current guess word
	public String setWordLength(String w) {
		
		// Get length of random word
		int length = w.length(); 
		// Convert string into char array
		char[] tempWord = w.toCharArray();
		// Fill word with lines for empty word
		for(int i = 0; i < length; i++) {
			tempWord[i] = '-';
		}
		// Convert back to string to return empty word
	    return String.valueOf(tempWord);
	}

	// Method - Check to see if entered letter is in word
	public String checkLetter(char l, String tc) {
		int i;
		letterFound = false;
		
		// Convert letter to uppercase
		l = Character.toUpperCase(l); 
		
		// Check for duplicate letter guess
		if((duplicateLetter(l)) && (firstTime == false)) {
			System.out.println("This letter has already been entered");
			return tc;
		}
				
		usedLetters.add(l); // Add current letter to used letter Array List
			
		// Convert string into char array
		char[] tempWord = wordToGuess.toCharArray();
		char[] tempCurrent = tc.toCharArray();
		// Compare letter guess against letters in word
		for(i = 0; i < wordToGuess.length(); i++) {
			if (l == tempWord[i]) { // letter match		
				tempCurrent[i] = tempWord[i]; // Add letter to current word				 
				wordCount = wordCount + 1;									
				letterFound = true;
				System.out.println("Letter " + l + " is in the word");
			}		
		}
					
		// Add one to lives taken when letter not in word
		if (!letterFound) {
			live = live + 1;
			System.out.println("Letter " + l + " is not in the word");
		}
		firstTime = false;
		return String.valueOf(tempCurrent);
	}
	
	// Method - Return current attempts
	public int livesLeft() {
		return 5 - live;
	}
	
	// Method - Return used letters list	
	public void lettersUsed() {
		System.out.print("Letters used : ");
		for(int i = 0; i < usedLetters.size(); i++ ) {
			System.out.print(usedLetters.get(i) + " ");
		}
		System.out.println();
	}
	
	// Method - Check for duplicate letter guess
	private boolean duplicateLetter(char l) {	
		for(int i = 0; i < usedLetters.size(); i++) {		
			if(l == usedLetters.get(i)) {
				return true;
			}
		}		
		return false;
	}
}