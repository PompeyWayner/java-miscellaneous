import java.util.*;

/**
 * class holding a banking customers name and transactions.
 * @author Wayne Sandford
 * @version 18-04-2019 01
 */
public class Customer {

	private String name;
	private List<Double> transactions;
	
	// Constructor
	public Customer(String name) {
		super();
		this.name = name;
		this.transactions = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Double> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Double> transactions) {
		this.transactions = transactions;
	}
}
