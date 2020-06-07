package domain;

import java.util.ArrayList;
import java.util.List;
import domain.result;
public class Circuit {

	protected String circuitName;
	public static float circuitLength;
	public static double circuitTime;
	
	public List<Rocket> rockets = new ArrayList<Rocket>();;

	public Circuit(String circuitName, float distance, double time) throws Exception {
		if(circuitName == null || circuitName.isEmpty())
			throw new Exception("The name is not correct");
		if(distance<=0)
			throw new Exception("The distance cannot under or equal 0");
		if(time<=0)
			throw new Exception("The time cannot under or equal 0");
		this.circuitName=circuitName;
		circuitLength=distance;
		circuitTime=time;
	}
	
	public void addRocket(Rocket rocket) throws Exception {
		if (rocket == null)
			throw new Exception ("The rocket cannot be null.");
		rockets.add(rocket);
	}

	public String loopCompetition() throws Exception {
		List<result> results = new ArrayList<result>();		
		String resultString = "";
		for (Rocket rocket : rockets) {
			resultString+="\n"+"---Rocket " + rocket.getName() + "---";
			rocket.resetRocket();
			while(rocket.getTime()<circuitTime && rocket.getFuelTank()>0 && rocket.getDistance()<circuitLength)
				resultString+=rocket.updateValues(circuitLength);
			results.add(rocket.getFinalResult(circuitTime));
		}
		return resultString+getResults(results);
	}
	
	public String getResults(List<result> results) {
		String resultString = "";
		results = result.sortList(results);
		resultString+="\n"+"\n"+result.isThereWinner(results) + "Results of the race:";
		for (int i = 0; i< results.size(); i++)
			resultString+="\n"+(i+1) + ". " + results.get(i).getName() + " with a time of: " +  results.get(i).getTimeString();
		return resultString;
	}
}