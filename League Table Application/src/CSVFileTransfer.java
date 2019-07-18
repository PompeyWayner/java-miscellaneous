import java.util.List;

/**
 * interface CSVFileTransfer provides method headers
 * for reading and writing to a CSV file.
 * @author Wayne Sandford
 * @version 28-04-2019 01
 */
public interface CSVFileTransfer {
	List<FootballTeam> loadObject();
	void saveObject(List<FootballTeam> objectCollection);
}
