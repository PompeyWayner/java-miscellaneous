import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * class LeagueTable 
 * @author Wayne Sandford
 * @verion 27-04-2019 2.1
 */
public class League implements CSVFileTransfer {
	
	private String division;
	private List<FootballTeam> teams;

	// Constructor
	public League(String division) {
		super();
		this.division = division;
		teams = new ArrayList<>();
	}

	public String getDivision() {
		return division;
	}

	public List<FootballTeam> getTeams() {
		return teams;
	}
	
	public void setTeams(List<FootballTeam> aTeam) {
		this.teams = aTeam;
	}
	
	/**
	 * Add a team to the league using a FootballTeam object.
	 * @param team a FootBallTeam object
	 * @return false if team already exists, otherwise adds team and return true.
	 * ** This method is currently only used in testing.
	 */
	public boolean addTeam(FootballTeam team) {
			
        if (teams.contains(team)) { // Team already exists
            System.out.println(team.getName() + " is already in this division");
            return false;
        } 
        // Team not found so add to league.
        teams.add(team);
        return true;
    }
	
	/**
	 * Add a team to the league using a team name String.
	 * @param team a FootBallTeam object
	 * @return false if team already exists, otherwise adds team and return true.
	 */
	public boolean addTeam(String aTeam) {
		FootballTeam team = findTeam(aTeam);	
        if (team != null) { // Team already exists.   
            return false;
        } 
        // Team not found so add to division
       // FootballTeam newTeam = new FootballTeam(aTeam);
       // FootballTeam newTeam = new FootballTeam(aTeam);
        teams.add(new FootballTeam(aTeam));
        return true;
    }

	/**
	 * Returns size of league.
	 * @return teams an int of the size of the teams league.
	 */
    public int numTeams() {
        return this.teams.size();
    }

    /**
     * Add a match result to the two teams concerned.
     * @param teamA a String representing a teamA.
     * @param teamB a String representing a teamB.
     * @param teamAScore an int representing teamA goals scored.
     * @param teamBScore an int representing teamB goals scored.
     */
    public void recordResult(String teamA, String teamB,
            int teamAScore, int teamBScore) {
    	FootballTeam tA = findTeam(teamA);
    	FootballTeam tB = findTeam(teamB);
    	if(tA == null || tB== null || teamA.toLowerCase().equals(teamB.toLowerCase())) {
    		System.out.println("One or more invalid team names - result error");
    		return;
    	} //*** add test for negative scores ***
    	if(teamAScore > teamBScore) {
			tA.incWon(); tA.setResults("W");
			tB.incLost(); tB.setResults("L");
		} else if(teamAScore < teamBScore) {
			tA.incLost(); tA.setResults("L");
			tB.incWon(); tB.setResults("W");
		} else {// drew
			tA.incDrew(); tA.setResults("D");
			tB.incDrew(); tB.setResults("D");
		}
    	tA.setGoalsFor(tA.getGoalsFor() + teamAScore);	
		tA.setGoalsAgainst(tA.getGoalsAgainst() + teamBScore);
		tB.setGoalsFor(tB.getGoalsFor() + teamBScore);	
		tB.setGoalsAgainst(tB.getGoalsAgainst() + teamAScore);
		System.out.println("The result between " + teamA + " and " + teamB + " has been added");
    }
    	
   
    /**
     * Prints out the statistics for all teams in the
     * division given by the method argument.
     * @param division String of division to be displayed.
     */
    public void printOutTable(String division) {
       Collections.sort(teams);
       System.out.println(division);
       System.out.format("%-20s %3s %3s %3s %3s %3s %3s %3s\n", 
                         "Name","PL","W","L","D", "F", "A", "Pts" );
       for(FootballTeam aTeam : this.teams) {
          System.out.format("%-20s %3d %3d %3d %3d %3d %3d %3d\n",
        		            aTeam.getName(), aTeam.gamesPlayed(),
                            aTeam.getWon(),  aTeam.getLost(), 
                            aTeam.getDrew(), aTeam.getGoalsFor(),
                            aTeam.getGoalsAgainst(), aTeam.totalPoints());
       }
    }
    
    /**
     * Print out the statistics for a single team.
     * @param aTeam a String representing a team.
     */
    public void printTeam(String aTeam) {
    	FootballTeam team = findTeam(aTeam);
    	if(team != null) { // Team exists
    		System.out.println("\n-----------------\n" + team.getName() + "\n-----------------");
    		System.out.println("Won    : " + team.getWon() +
    				"\nLost   : " + team.getLost() +
    				"\nDrawn  : " + team.getDrew() +
    				"\nPoints : " + team.totalPoints());
    		System.out.println("Results streak : " + team.getResults());
    	} else {
    		System.out.println("Team does not exist");
    	}
    }
    
    /**
     * Tests to see if teamName is a valid team.
     * @param teamName a String representing a team.
     * @return checkedTeam a Football Team object if team is valid, otherwise returns null.
     */
    private FootballTeam findTeam(String teamName) {
    	for(int i=0; i<this.teams.size(); i++) {
            FootballTeam checkedTeam = this.teams.get(i);
            if(checkedTeam.getName().toLowerCase().equals(teamName.toLowerCase())) {
                return checkedTeam;
            }
        }
        return null;
    }
 
    /**
     * Loads a League's data details from a file.
     * @return loadedTeams a List of FootballTeams.
     */
	@Override
	public List<FootballTeam> loadObject() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter file name load data from (i.e aFile.csv) > ");
		String fileName = scanner.nextLine();
		//scanner.close();
		String pathname = "C:\\Users\\wsand\\Documents\\M250\\" + fileName;
		File leagueFile = new File(pathname);
		Scanner bufferedScanner = null;
		List<FootballTeam> loadedTeams  = new ArrayList<>();
		FootballTeam aTeam;
		try {
			Scanner lineScanner;
			String currentLine;
			bufferedScanner = new Scanner(new BufferedReader(new FileReader(leagueFile)));
			while(bufferedScanner.hasNextLine()) {
				currentLine = bufferedScanner.nextLine();
				lineScanner = new Scanner(currentLine);
				lineScanner.useDelimiter(",");
				aTeam = new FootballTeam(lineScanner.next());
				aTeam.setWon(lineScanner.nextInt());
				aTeam.setLost(lineScanner.nextInt());
				aTeam.setDrew(lineScanner.nextInt());
				aTeam.setGoalsFor(lineScanner.nextInt());
				aTeam.setGoalsAgainst(lineScanner.nextInt());
				aTeam.setResults(lineScanner.next());
				loadedTeams.add(aTeam);
			}
		} catch(Exception anException) {
			System.out.println("Error reading from the file - " + anException);
		} finally {
			try {
					bufferedScanner.close();
				} catch(Exception anException) {
					System.out.println("Error closing file - " + anException);
				}
			}
		return loadedTeams;
		}	

	/**
	 * Save's all the FootbllTeam objects data to disk.
	 * @param objectCollection a List of Football Teams.
	 */
	@Override
	public void saveObject(List<FootballTeam> objectCollection) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter filename to save to (i.e aFile.csv > )");
		String fileName = scanner.nextLine();
		//scanner.close();
		String pathname = "C:\\Users\\wsand\\Documents\\M250\\" + fileName;
		File leagueFile = new File(pathname);
		BufferedWriter bufferedFileWriter = null;
		try {
			bufferedFileWriter = new BufferedWriter(new FileWriter(leagueFile));
			for(FootballTeam eachTeam : objectCollection) {
				bufferedFileWriter.write(eachTeam.getName() + "," + eachTeam.getWon() + "," +
			                             eachTeam.getLost() + "," + eachTeam.getDrew() + "," +
						                 eachTeam.getGoalsFor() + "," + eachTeam.getGoalsAgainst() + "," +
			                             eachTeam.getResults().toString());
				bufferedFileWriter.newLine();
			}
		} catch(Exception anException) {
			System.out.println("Error writing to file - " + anException);
		} finally {
			try {
				bufferedFileWriter.close();
			} catch(Exception anException) {
				System.out.println("Error closing file - " + anException);
			}
		}
	}
		
    
}
