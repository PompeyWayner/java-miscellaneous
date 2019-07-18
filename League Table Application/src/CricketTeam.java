
public class CricketTeam extends Team implements Comparable<CricketTeam> {

	public CricketTeam(String name) {
		super(name);
	}

	@Override
	public int totalPoints() {
		return ((super.getWon() * 20) + (super.getDrew() * 10));
	}
	
	@Override
    public int compareTo(CricketTeam team) {
        if(this.totalPoints() > team.totalPoints()) {
            return -1;
        } else if(this.totalPoints() < team.totalPoints()) {
            return 1;
        } else {
            return 0;
        }
    }

	@Override
	public int gamesPlayed() {
		// TODO Auto-generated method stub
		return 0;
	}
}
