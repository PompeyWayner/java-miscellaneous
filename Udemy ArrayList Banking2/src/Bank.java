import java.util.ArrayList;
import java.util.List;

/**
 * class stores a number of bank branches
 * @author Wayne Sandford
 * @version 20-04-2019 02
 */
public class Bank {

	private String name;
	private List<Branch> branches;
	
	// Constructor
	public Bank(String name) {
		super();
		this.name = name;
		this.branches = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Branch> getBranches() {
		return branches;
	}
	
	/**
	 * Add a branch to the bank.
	 * @param aBranch a String representing branch name.
	 * @return true if branch added, otherwise false.
	 */
	public boolean addBranch(String aBranch)
	{
		if(findBranch(aBranch) == null) { // Branch does not exist
			Branch newBranch = new Branch(aBranch);
			branches.add(newBranch);
			return true;
		}
		return false;
	}
	
	/**
	 * Add a new customer to the branch.
	 * @param aName a String representing customer name.
	 * @param aBranch a String representing branch name.
	 * @param openingTransacrion a double representing a transaction amount.
	 * @return true if branch exists and customer added to branch, otherwise returns false.
	 */
	public boolean addCustomerToBranch(String aName, String aBranch, double openingTransaction)
	{
		Branch existingBranch = findBranch(aBranch);
		if(existingBranch != null) { // Branch exists.
			return (existingBranch.openCustomerAccount(aName, openingTransaction));
		}
		System.out.println("Branch does not exist");
		return false;
	}
	
	/**
	 * Add a customer transaction to their account.
	 * @param aName a String representing customer name.
	 * @param aBranch a String representing branch name.
	 * @param transactionAmount a double representing a transaction amount.
	 * @return true if branch and customer exist therefore transaction performed,otherwise false.
	 */
	public boolean addCustomerTransaction(String aName, String aBranch, double transactionAmount)
	{
		Branch existingBranch = findBranch(aBranch);
		if(existingBranch != null) { // Branch exists.
			return (existingBranch.addCustomerTransaction(aName, transactionAmount));	
		}
		return false;
	}
	
	/**
	 * Prints out all transactions for a customer from a branch.
	 * @param aBranch a String representing branch name.
	 * @param aName a String representing customer name.
	 * @return true if branch and customer names exist therefore customer transactions displayed, otherwise false.
	 */
	public boolean displayCustomerTransactions(String aBranch, String aName)
	{
		Branch existingBranch = findBranch(aBranch);
		if(existingBranch != null) { // Branch exists.
			return (existingBranch.displayCustomerTransactions(aName));
		}
		System.out.println("Branch not found");
		return false;
	}
	
	/**
	 * Prints out all branches.
	 * @return true is branches to display, otherwise false.
	 */
	public boolean displayBranches()
	{
		if(branches.isEmpty() ) {
			return false;
		}
		for(Branch eachBranch : branches) {
			System.out.println(eachBranch.getName());
		}
		return true;
	}
	
	/**
	 * Prints all customers of a branch.
	 * @param aBranch a String representing a branch name.
	 * @return true if branch exists therefore customers are displayed, otherwise false.
	 */
	public boolean displayAllCustomersOfBranch(String aBranch) {
		Branch existingBranch = findBranch(aBranch);
		if(existingBranch != null) { // Branch exists.
			existingBranch.displayCustomers();
			return true;
		}
		return false;	
	}
	
	/**
	 * Tests to see if branch exists and returns the branch.
	 * @param branchName a String representing the branch to search for.
	 * @return Branch a Branch object representing the branch customer
	 *         otherwise returns null (branch not found).
	 */
	private Branch findBranch(String branchName) {
        for(int i=0; i<this.branches.size(); i++) {
            Branch checkedBranched = this.branches.get(i);
            if(checkedBranched.getName().equals(branchName)) {
                return checkedBranched;
            }
        }
        return null;
	}
}