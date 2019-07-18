import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainLeagueTest {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
//		FootballTeam portsmouth = new FootballTeam("Portsmouth");
//		CricketTeam yorkshire = new CricketTeam("Yorkshire");
		
		League league = new League("Premier League");
//		LeagueTable cricket = new LeagueTable("League One");
//		
		// VARIOUS TEST DATA 
		
//		l.addTeam(portsmouth);
//		l.addTeam(new FootballTeam("Liverpool"));
//		l.addTeam(new FootballTeam("Arsenal"));
//		l.addTeam(new FootballTeam("Manchester Utd"));
//		l.addTeam(new FootballTeam("Chelsea"));
//		l.addTeam(new FootballTeam("Tottenham"));
//		l.addTeam((portsmouth)); // duplicate - will not be added
		// if added as new FootballTeam("----")); - comparison in addTeam() does not work
		
		// compiler message - trying to add cricket team to football team - l.addTeam(yorkshire);
		
		
		league.recordResult("Portsmouth", "Arsenal", 3, 2);
		league.recordResult("Manchester Utd", "Chelsea", 0, 2);
		league.recordResult("Tottenham", "Liverpool", 1, 2);
		league.recordResult("Portsmouth", "Manchester Utd", 3, 3);
		league.recordResult("Burnley", "Liverpool", 1, 2);
		league.recordResult("manchester city", "Liverpool", 1, 1);
		league.recordResult("Arsenal", "Fulham", 1, 1);
		league.recordResult("tottenham", "watford", 1, 0);
		league.recordResult("bournemouth", "wolves", 4, 0);
		league.recordResult("chelsea", "manchester city", 3, 1);
		league.recordResult("Everton", "Cardiff", 3, 0);
//		league.recordResult("cardiff", "fulham", 1, 0);
//		league.recordResult("huddersfield", "brighton", 0, 2);
//		league.recordResult("liverpool", "huddersfield", 6, 0);
//		league.recordResult("newcastle", "everton", 1, 1);
//		league.recordResult("Arsenal", "wolves", 1, 0);
//		league.recordResult("crystal palace", "manchester utd", 3, 3);
//		league.recordResult("wolves", "crystal palace", 2, 0);
//		league.recordResult("brighton", "bournemouth", 2,2);
//		league.recordResult("burnley", "portsmouth", 1, 3);
//		league.recordResult("Arsenal", "manchester utd", 1, 2);
//		league.recordResult("manchester city", "fulham", 3, 2);
//		league.recordResult("tottenham", "newcastle", 1, 0);
//		league.recordResult("manchester utd", "Liverpool", 0, 0);
//		league.recordResult("chelsea", "watford", 2, 1);
//		league.recordResult("huddersfield", "portsmouth", 1, 2);
//		league.recordResult("west ham", "Leicester", 1, 2);
//		league.recordResult("leicester", "burnley", 1, 1);
//		league.recordResult("newcastle", "Leicester", 3, 1);
//		league.recordResult("leicester", "bournemouth", 1, 0);
//		league.recordResult("cardiff", "west ham", 1, 2);
//		league.recordResult("Arsenal", "Liverpool", 1, 5);
//		league.recordResult("west ham", "watford", 1, 4);
//		league.recordResult("tottenham", "cardiff", 3, 3);
//		league.recordResult("burnley", "everton", 2, 5);
//		league.recordResult("brighton", "watford", 1, 2);
//		league.recordResult("huddersfield", "chelsea", 1, 1);
//		league.recordResult("wolves", "brighton", 2, 0);
//		league.recordResult("everton", "watford", 1, 5);
//		league.recordResult("crystal palace", "bournemouth", 1, 1);
//		league.recordResult("manchester city", "crystal palace", 1, 5);
//		league.recordResult("newcastle", "fulham", 1, 0);
//		league.recordResult("west ham", "leicester", 1, 0);
//		
		
		//l.printOutTable(l.getDivision());	
		//Collections.sort(l.getTeams());	
		//league.printOutTable(league.getDivision());
		
		
		//cricket.addTeam(new CricketTeam("Hampshire"));
		//cricket.addTeam(new CricketTeam("Somerset"));
		//compiler message - trying to add football team to cricket team - cricket.addTeam(portsmouth);
		//cricket.recordResult("Hampshire", "Somerset", 533, 432);
		//Collections.sort(cricket.getTeams());	
		//cricket.printOutTable(l.getDivision());
		
		
		
		boolean quit = false;
		int option = 0;
		displayMenu();
		while(!quit) {
			System.out.print("\nEnter option number > ");
			try {
				option = scanner.nextInt();
			} catch(Exception anException) {
				System.out.println("Invalid input");
				
			}
				
				scanner.nextLine();
				switch(option) {
					case 0:
						System.out.println("Goodbye...");
						quit = true;
						break;		
					case 1:
						displayMenu();
						break;	
					case 2:
						addResult(league);
						break;
					case 3:
						league.printOutTable(league.getDivision());
						break;
					case 4:
						displayTeam(league);
						break;
					case 5:
						saveLeague(league);
						break;
					case 6:
						loadLeague(league);
						break;
					case 7:
						populate(league);
						break;
					case 8:
						addTeam(league);
						break;
					default:
						System.out.println("Number between 0 and 7 is required");
				}		
		}
		scanner.close();
	}
	
	/**
	 * Populate a league table with 20 teams simulating premier league.
	 * @param l a League object.
	 */
	public static void populate(League l) {
		
		l.getTeams().clear();
		l.addTeam(new FootballTeam("Liverpool"));
		l.addTeam(new FootballTeam("Arsenal"));
		l.addTeam(new FootballTeam("Manchester Utd"));
		l.addTeam(new FootballTeam("Chelsea"));
		l.addTeam(new FootballTeam("Tottenham"));
		l.addTeam(new FootballTeam("Manchester City"));
		l.addTeam(new FootballTeam("Everton"));
		l.addTeam(new FootballTeam("Watford"));
		l.addTeam(new FootballTeam("Wolves"));
		l.addTeam(new FootballTeam("West Ham"));
		l.addTeam(new FootballTeam("Leicester"));
		l.addTeam(new FootballTeam("Cardiff"));
		l.addTeam(new FootballTeam("Brighton"));
		l.addTeam(new FootballTeam("Fulham"));
		l.addTeam(new FootballTeam("Portsmouth"));
		l.addTeam(new FootballTeam("Burnley"));
		l.addTeam(new FootballTeam("Crystal Palace"));
		l.addTeam(new FootballTeam("Bournemouth"));
		l.addTeam(new FootballTeam("Newcastle"));
		l.addTeam(new FootballTeam("Huddersfield"));
	}

	/**
	 * Menu interface.
	 */
	public static void displayMenu() {
		System.out.println("\n1 -\tDisplay menu"
				+ "\n2 - \tAdd a match result"
				+ "\n3 - \tDisplay league table"
				+ "\n4 - \tDisplay team details"
				+ "\n5 - \tSave league"
				+ "\n6 - \tLoad league"
				+ "\n7 - \tCreate empty league"
				+ "\n8 - \tAdd a new team"
				+ "\n0 - \tQuit");
	}
	
	/**
	 * Sub-menu interface for adding a match result to the league.
	 * @param l a League object.
	 */
	public static void addResult(League l) {
		System.out.println("Enter result in form of <Team A,TeamA Goals,TeamB Goals,TeamB");
		String result = scanner.nextLine();
		
		String[]resultData = result.split(",");
		
		// Add check for valid data input - check to see if entered ints are positive 
		// rewrite this check!!
		if((resultData.length) == 4) {
			try {
				l.recordResult(resultData[0], resultData[3], 
						Integer.parseInt(resultData[1]), Integer.parseInt(resultData[2]));	
			} catch (NumberFormatException anException) {
				System.out.println("Invalid entry - one or more data entries in wrong format");
			}
		} else {
			System.out.println("Invalid entry - not all entries added");
		}
	}
	
	/**
	 * Sub-menu interface to display a teams statistics.
	 * @param l a League object.
	 */
	public static void displayTeam(League l) {
		System.out.print("Enter team to display > ");
		String team = scanner.nextLine();
		l.printTeam(team);
	}
	
	/**
	 * Sub-menu interface to save a league details to disk.
	 * @param l a League object.
	 */
	public static void saveLeague(League l) {	
		l.saveObject(l.getTeams());
	}
	
	/**
	 * Sub-menu interface to load a league details from disk.
	 * @param l a League object.
	 */
	public static void loadLeague(League l) {
		List<FootballTeam> teams = l.loadObject();
		l.setTeams(teams);	
	}
	
	public static void addTeam(League l) {
		System.out.println("Enter new team to add to the league > ");
		String newTeam = scanner.nextLine();
		
		if(l.addTeam(newTeam)) {
			System.out.println(newTeam + " has been added to the league");
		} else {
		       System.out.println(newTeam + " is already in this division");
		}
	}
}
