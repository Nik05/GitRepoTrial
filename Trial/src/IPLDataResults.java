import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Team{
	private String teamName;
	private int totalRuns;
	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	private int totalWickets;
	
	public int getTotalWickets() {
		return totalWickets;
	}

	public void setTotalWickets(int totalWickets) {
		this.totalWickets = totalWickets;
	}

	Team(String name){
		teamName = name;
		totalRuns = 0;
		totalWickets = 0;
	}
	
	void addRuns(int runs) {
		totalRuns += runs;
	}
	
	void addWickets(int wicket) {
		totalWickets += wicket;
	}
	
	static void printTeamData(Team t1, Team t2, int matchId) {
		System.out.println("MatchId "+ matchId + ", Winner " + ((t1.totalRuns > t2.totalRuns)?(t1.teamName+"("+t1.getTotalRuns()+"/"+ t1.getTotalWickets()+")"):(t2.teamName+"("+t2.getTotalRuns()+"/"+ t2.getTotalWickets()+")"))+ ", Losser " + ((t1.totalRuns < t2.totalRuns)?(t1.teamName+"("+t1.getTotalRuns()+"/"+ t1.getTotalWickets()+")"):(t2.teamName+"("+t2.getTotalRuns()+"/"+ t2.getTotalWickets()+")")));
	}
}
class LineProcessor{
	public static String[] splitData(String line) {
		String lineData[] = line.split(",");
		return lineData;
	}
}
public class IPLDataResults {
	public static void main(String []args) throws IOException {
		BufferedReader buffReader;
		FileReader fileReader = new FileReader("G:\\input data\\deliveries.csv");
		buffReader = new BufferedReader(fileReader);
		String currentLine;
		String data[];
		int inningsId, over, ball, runs, wicket, matchId;
		Team team1 = null;
		Team team2 = null;
		
		while((currentLine = buffReader.readLine()) != null) {
			data = LineProcessor.splitData(currentLine);
			if(data[0].startsWith("match_id")) {
				continue;
			}
			matchId = Integer.parseInt(data[0]);
			inningsId = Integer.parseInt(data[1]);
			over = Integer.parseInt(data[4]);
			ball = Integer.parseInt(data[5]);
			runs = Integer.parseInt(data[17]);
			wicket = (data.length<20)?0:1;
			if(inningsId == 1){
				if(over == 1) {
					if(ball == 1) {
						if(team1 != null || team2 != null) {
							Team.printTeamData(team1, team2, matchId-1);
						}
						team1 = new Team(data[2]);
						team2 = new Team(data[3]);
					}
				}
				team1.addRuns(runs);
				team1.addWickets(wicket);
			}else if(inningsId == 2){
				team2.addRuns(runs);
				team2.addWickets(wicket);
			}

		}
		
		
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
