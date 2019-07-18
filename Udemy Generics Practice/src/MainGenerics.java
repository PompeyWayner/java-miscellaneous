
public class MainGenerics {

	public static void main(String[] args) {
		
		League<FootballTeam> fLeague = new League<>("Premier League");
		fLeague.addTeam("Portsmouth");
//		fLeague.addTeam("Liverpool");
//		fLeague.addTeam("Brighton");
//		fLeague.addTeam("Portsmouth");
//		
        fLeague.printTeams();
	}

}
