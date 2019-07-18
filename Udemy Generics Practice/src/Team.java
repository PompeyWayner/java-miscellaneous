/**
 * Abstract class Team gives basic attributes of a Team.
 * @author Wayne Sandford
 * @version 28-04-2019 1.1
 */
public abstract class Team {
	
	protected String name;
	protected int won;
	protected int lost;
	protected int drew;
	
	// Constructor
	public Team(String name) {
		super();
		this.name = name;
		this.won = 0;
		this.lost = 0;
		this.drew = 0;
	}

	public String getName() {
		return name;
	}

	public int getWon() {
		return won;
	}

	public int getLost() {
		return lost;
	}

	public int getDrew() {
		return drew;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public void setDrew(int drew) {
		this.drew = drew;
	}	
	
	public abstract int totalPoints();
	public abstract int gamesPlayed();

}
