import java.util.Scanner;

/**
 * Application to add customers to branches of a bank.
 * @author Wayne Sandford
 * @version 18-04-2019 01
 */
public class MainBank {

	public static Scanner scanner = new Scanner(System.in);
	public static Bank bank = new Bank("LLoyds");
	
	public static void main(String[] args) {
		
		int option = 0;
		boolean quitProgram = false;
		displayOptions();
		while(!quitProgram) {
		
			System.out.print("\nEnter option number (option 1 to display options) > ");
			option = scanner.nextInt();
			scanner.nextLine();
        
			switch(option) {
        		case 1: 
        			displayOptions();
        			break;
        				
        		case 2: 
        			addBranch();
        			break;
        				
        		case 3: 
        			addNewCustomerToBranch();
        			break;
        				
        		case 4:
        			addTransactionExistingCustomer();
        			break;
        				
        		case 5: 
        			displayCustomerTransactions();		
        			break;
        	
        		case 6:
        			displayBranches();
        			break;
        			
        		case 7:
        			displayAllCustomersOfBranch();
        			break;
        		
        		case 8: 
        			quitProgram = true;
        		    System.out.println("Program has finished. Goodbye....");
        		    break;
        		    
        		default: 
        			System.out.println("Number must be between 1 and 7");
			}
		}

	}
	
	public static void displayOptions() {
		System.out.println("1 - \tDisplay options");
		System.out.println("2 - \tAdd a new branch");
		System.out.println("3 - \tOpen a new customer account");
		System.out.println("4 - \tAdd new transaction to existing customer account");
		System.out.println("5 - \tDisplay a customers transactions");
		System.out.println("6 - \tDisplay current branches");
		System.out.println("7 - \tDisplay customers of a branch");
		System.out.println("8 - \tQuit");		
	}
	
	public static void addBranch() {
		System.out.print("Enter branch name to add > ");
        String name = scanner.nextLine();
		if(bank.addBranch(name)) {
			System.out.println(name + " has been added to the list of branches");
		} else {
			System.out.println("Branch name already exists - cannot add duplicate branch");
		}
	}

	public static void addNewCustomerToBranch() {
		System.out.print("Enter branch > ");
		String branch = scanner.nextLine();
		System.out.print("Enter new customer name > ");
		String name = scanner.nextLine();
		System.out.print("Enter transaction amount > ");
		double openingTransaction = scanner.nextDouble();
		scanner.nextLine();
		if(bank.addCustomerToBranch(name, branch, openingTransaction)) {
			System.out.println(name + " account has been opened at the " + branch + " branch");
		} else {
			System.out.println("Cannot open account for customer " + name);
		}
	}
	
	public static void addTransactionExistingCustomer() {
		System.out.print("Enter branch > ");
		String branch = scanner.nextLine();
		System.out.print("Enter customer name > ");
		String name = scanner.nextLine();
		System.out.print("Enter transaction amount > ");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		if(bank.addCustomerTransaction(name, branch, amount)) {
			System.out.println(name + " account has been updated with the transaction of " + amount + " at the " + branch + " branch");
		} else {
			System.out.println("");
		}
	}
	
	public static void displayBranches() {
		if(bank.displayBranches())
		{
			System.out.println("Total branches is " + bank.getBranches().size());
		} else {
			System.out.println("No branches to display");
		}
	}
	
	public static void displayCustomerTransactions() {
		System.out.print("Enter branch > ");
		String branch = scanner.nextLine();
		System.out.print("Enter customer name > ");
		String name = scanner.nextLine();
		if(bank.displayCustomerTransactions(branch, name)) {
			System.out.println("Transactions for account " + name + " is complete");
		} else {
			System.out.println("Cannot display transactions for " + name + " account");
		}
	}
	
	public static void displayAllCustomersOfBranch() {
		System.out.print("Enter branch > ");
		String branch = scanner.nextLine();
		if(bank.displayAllCustomersOfBranch(branch)) {
			System.out.println("Customer listing for the " + branch + " branch is complete");
		}
	}
}

