import java.util.ArrayList;
import java.util.List;

/**
 * class holding a banking customers name and transactions.
 * @author Wayne Sandford
 * @version 20-04-2019 02
 */
public class Customer {

	private String name;
	private List<Double> transactions;
	
	// Constructor
	public Customer(String name, double openingTransaction) {
		super();
		this.name = name;
		this.transactions = new ArrayList<>();
		this.addTransaction(openingTransaction);
		
	}

	public String getName() {
		return name;
	}

	public List<Double> getTransactions() {
		return transactions;
	}
	
	/**
	 * Adds a transaction.
	 * @param amount a double representing transaction amount to add to transactions list.
	 */
	public void addTransaction(double amount) {
		this.transactions.add(amount);
	}
}
