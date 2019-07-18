import java.util.ArrayList;
import java.util.List;

/**
 * class holds a branch details of a bank.
 * @author Wayne Sandford
 * @version 20-04-2019 02
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
	
	/**
	 * Add customer to the branch.
	 * @param aName a String representing customer name.
	 * @param openingAmount a double representing transaction amount.
	 * @return true if customer does not exist therefore adding new customer, otherwise false.
	 */
	public boolean openCustomerAccount(String aName, double openingAmount)
	{
		if(findCustomer(aName) == null) { // Customer does not exist.
			Customer newCustomer = new Customer(aName, openingAmount); // Create new customer.
			customers.add(newCustomer); // Add new customer to customer list.
			return true;
		}
		System.out.println("Customer already exists");
		return false;
	}
		
	/**
	 * Add a customer transaction to their account.
	 * @param aName a String representing customer name.
	 * @param transactionAmount a double representing transaction amount.
	 * @return true if customer exists therefore adding transaction to customer, otherwise false.
	 */
	public boolean addCustomerTransaction(String aName, double transactionAmount)
	{
		Customer existingCustomer = (findCustomer(aName));
		if(existingCustomer != null) { // Customer found in list.
			existingCustomer.addTransaction(transactionAmount);
			return true;
		}
		
		return false;
	}
		
	
	/**
	 * Prints a customers transactions.
	 * @param aName a String representing customer name.
	 * @return true if customer exists therefore displaying customer transactions, otherwise false.
	 */
	public boolean displayCustomerTransactions(String aName) {
		Customer existingCustomer = (findCustomer(aName));
		if(existingCustomer != null) { // Customer found in list.
			System.out.println("Customer : " + existingCustomer.getName());
			for(double eachTransaction : existingCustomer.getTransactions()) {
		    	System.out.println(eachTransaction);
		    }		
			return true;
		}	
		System.out.println("Customer not found");
		return false;
	}
	
	/**
	 * Display all customers in branch.
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
	 * Tests to see if customer exists and returns the customer.
	 * @param customerName a String representing the customer to search for.
	 * @return Customer a Customer object representing the found customer
	 *         otherwise returns null (customer not found).
	 */
	private Customer findCustomer(String customerName) {
        for(int i=0; i<this.customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }

        return null;
    }
}

