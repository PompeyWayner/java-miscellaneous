import java.util.ArrayList;
import java.util.List;

public class League <T extends Team>{
	private List<T> teams;
	private String name;

	public League(String aName) {
		super();
		this.name = aName;
		this.teams = new ArrayList<>();
	}

	public List<T> getTeams() {
		return teams;
	}

	public void setTeams(List<T> teams) {
		this.teams = teams;
	}

	public String getName() {
		return name;
	}

	public void addTeam(T aTeam) {
		this.teams.add(aTeam);
	}
	
	public boolean addTeam(String aTeam) {
		System.out.println(aTeam);
		T team = findTeam(aTeam);
		System.out.println(team);
		if(team != null) {
			System.out.println("Team already exists");
			return false;
		}
		this.teams.add(team);
		return true;
	}
	
	public void printTeams() {
		for(T eachTeam : teams) {
			System.out.println(eachTeam);
		}
	}
	
	private T findTeam(String teamName) {
    	for(int i=0; i<this.teams.size(); i++) {
            T checkedTeam = this.teams.get(i);
            if(checkedTeam.getName().toLowerCase().equals(teamName.toLowerCase())) {
            	System.out.println(checkedTeam.name);
                return checkedTeam;
            }
        }
        return null;
    }
  
	
	
}
