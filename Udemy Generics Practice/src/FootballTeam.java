/** 
 * class FootballTeam uses abstract class Team
 * @author Wayne Sandford
 * @version 28-04-2019 1.3
 */
public class FootballTeam extends Team {//implements Comparable<FootballTeam> {
	
	private int goalsFor;
	private int goalsAgainst;
	private StringBuilder results;
	
	public FootballTeam(String name) {
		super(name);
		this.goalsFor = 0;
		this.goalsAgainst = 0;
		this.results = new StringBuilder();
	}

	public int getGoalsFor() {
		return goalsFor;
	}

	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}
	
	public StringBuilder getResults() {
		return results;
	}

	public void setResults(String result) {
		this.results.append(result);
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}
    
	public void incWon() {
		this.won++;
	}
	
	public void incLost() {
		this.lost++;
	}
	
	public void incDrew() {
		this.drew++;
	}
	@Override
	public int totalPoints() {
		return ((super.getWon() * 3) + (super.getDrew()));
	}
	
	
	@Override
	public int gamesPlayed() {
		return super.getWon() + super.getLost() + super.getDrew();
	}

	/**
	 * Compare points of two teams. If points are the same then
	 * compares goal difference.
	 */
//	@Override
//    public int compareTo(FootballTeam team) {
//        if(this.totalPoints() > team.totalPoints()) {
//            return -1;
//        } else if(this.totalPoints() < team.totalPoints()) {
//            return 1;
//        } else { // points equal so now check goal difference
//        	if((this.goalsFor - this.goalsAgainst) > (team.getGoalsFor() - team.getGoalsAgainst())) {
//        		return -1;
//        	} else if((this.goalsFor - this.goalsAgainst) < (team.getGoalsFor() - team.getGoalsAgainst())) {
//        		return 1;
//        	} else {
//        		return 0;
//        	}
//        }
//    }
}
