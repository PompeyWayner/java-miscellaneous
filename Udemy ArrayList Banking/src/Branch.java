import java.util.*;

/**
 * class holds a branch details of a bank.
 * @author Wayne Sandford
 * @version 18-04-2019 01
 */
public class Branch {

	private String name;
	private List<Customer> customers;
	
	public Branch(String aBranch) {
		super();
		this.name = aBranch;
		this.customers = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	/**
	 * Add customer to the branch.
	 */
	public boolean openCustomerAccount(String aName, double openingAmount)
	{
		if(isCustomer(aName)) { // Customer with this name already exists
			System.out.println("Customer already exists - cannot add customer");
			return false;
		} 
		Customer newCustomer = new Customer(aName);
		newCustomer.getTransactions().add(openingAmount);
		customers.add(newCustomer);
        // test loop to display customers
		for(Customer eachCustomer : customers)
		{
			System.out.println(eachCustomer.getName());
		}
		System.out.println("Number of customers is " + customers.size());
		return true;
	}
	
	/**
	 * Add a customer transaction to their account.
	 */
	public boolean addCustomerTransaction(String aName, double transactionAmount)
	{
		if(isCustomer(aName)) { // Customer found
			for(Customer eachCustomer : customers) {
				if(eachCustomer.getName().equals(aName)) {
					eachCustomer.getTransactions().add(transactionAmount);
					return true;
				}
			}
		}
		System.out.println("Customer not found");
		return false;
	}
	
	/**
	 * Display a customers transactions
	 */
	public boolean displayCustomerTransactions(String aName) {
		if(isCustomer(aName)) { // Customer found
			for(Customer eachCustomer : customers) {
				if(eachCustomer.getName().equals(aName)) {
				    for(double eachTransaction : eachCustomer.getTransactions()) {
				    	System.out.println(eachTransaction);
				    }
				    return true;
				}
			}
		} 
		return false;
	}
	
	/**
	 * Display all customers in branch
	 */
	public void displayCustomers()
	{
		double balance;
		for(Customer eachCustomer : customers) {
			balance = 0.0;
			for(Double eachTransaction : eachCustomer.getTransactions() ) {
				balance += eachTransaction;
			}
			System.out.println(eachCustomer.getName() + "\t" + balance);
		}
	}
	
	/**
	 * Tests to see if the supplied name is in the customer list.
	 * @param aName a String representing the customer name 
	 * @return true if name is in list, otherwise false.
	 */
	private boolean isCustomer(String aName)
	{
		for(Customer eachCustomer : customers)
		{
			if(eachCustomer.getName().equals(aName))
			{
				return true;
			}
		}
		return false;
	}
}
