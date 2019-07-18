import java.util.*;

/**
 * class stores a number of bank branches
 * @author Wayne Sandford
 * @version 18-04-2019 01
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

	public void setName(String name) {
		this.name = name;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	
	/**
	 * Add branch to the bank.
	 */
	public boolean addBranch(String aBranch)
	{
		if(isBranch(aBranch)) { // Branch with this name already exists
			return false;
		} 
		Branch newBranch = new Branch(aBranch);
		branches.add(newBranch);
		return true;
	}
	

	/**
	 * Add customer to the branch.
	 */
	public boolean addCustomerToBranch(String aName, String aBranch, double openingTransaction)
	{
		if(isBranch(aBranch)) { // Branch with this name already exists
			for(Branch eachBranch : branches) {
				if(eachBranch.getName().equals(aBranch)) {
					eachBranch.openCustomerAccount(aName, openingTransaction);
					return true;
				}
			}
		} 
		System.out.println("Branch not found");
		return false;
	}
	
	
	/**
	 * Add a customer transaction to their account.
	 */
	public boolean addCustomerTransaction(String aName, String aBranch, double transactionAmount)
	{
		if(!isBranch(aBranch)) { //Branch not found
			System.out.println("Branch not found");
			return false;
		}
		for(Branch eachBranch : branches) {
			if(eachBranch.getName().equals(aBranch)) {
				if(eachBranch.addCustomerTransaction(aName, transactionAmount)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Prints out all transactions for a customer from a branch.
	 */
	public boolean displayCustomerTransactions(String aBranch, String aName)
	{
		if(isBranch(aBranch)) { //Branch found
			for(Branch eachBranch : branches) {
				if(eachBranch.getName().equals(aBranch)) {
					if(eachBranch.displayCustomerTransactions(aName)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Prints out all branches
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
	 * Display all customers of a branch
	 */
	public boolean displayAllCustomersOfBranch(String aBranch) {
		if(!isBranch(aBranch)) { //Branch not found
			System.out.println("Branch not found");
			return false;
		}
		for(Branch eachBranch : branches) {
			if(eachBranch.getName().equals(aBranch)) {	
				eachBranch.displayCustomers();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Tests to see if the supplied name is in the customer list.
	 * @param aName a String representing the customer name 
	 * @return true if name is in list, otherwise false.
	 */
	private boolean isBranch(String aBranch)
	{
		for(Branch eachBranch : branches)
		{
			if(eachBranch.getName().equals(aBranch))
			{
				return true;
			}
		}
		return false;
	}
}
