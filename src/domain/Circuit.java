package domain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import application.ResultController;
import application.dto.CircuitDto;
import application.dto.ResultDto;
import domain.Result;
import utilities.InvalidParamException;

public class Circuit {

	private String circuitName;
	private static float circuitLength;
	private static int circuitTime;
	
	private List<Rocket> rockets = new ArrayList<Rocket>();

	public Circuit(String circuitName, float distance, int time) throws Exception {
		if(circuitName == null || circuitName.equals(""))
			throw new Exception("The name is not correct");
		if(distance<=0)
			throw new Exception("The distance cannot under or equal 0");
		if(time<0)
			throw new Exception("The time cannot under or equal 0");
		this.circuitName=circuitName;
		circuitLength=distance;
		circuitTime=time;
	}
	
	public Circuit(CircuitDto circuit) throws Exception {
		if(circuit==null) throw new InvalidParamException();
		this.circuitName=UUID.randomUUID().toString();
		circuitLength=circuit.getCircuitLength();
		circuitTime=circuit.getCircuitTime();
	}
	
	public String getCircuitName() {
		return circuitName;
	}

	public float getCircuitLength() {
		return circuitLength;
	}

	public  int getCircuitTime() {
		return circuitTime;
	}

	public List<Rocket> getRockets() {
		return rockets;
	}

	public void addRocket(Rocket rocket) throws Exception {
		if (rocket == null)
			throw new Exception ("The rocket cannot be null.");
		rockets.add(rocket);
	}
	
	public void addRocket(ArrayList<Rocket> rocket) throws Exception {
		if (rocket == null)
			throw new Exception ("The rockets cannot be null.");
		rockets.addAll(rocket);
	}

	public String loopCompetition() throws Exception {
		List<Result> results = new ArrayList<Result>();		
		String resultString = "";
		for (Rocket rocket : rockets) {
			resultString+="\n"+"---Rocket " + rocket.getName() + "---";
			rocket.resetRocket();
			while(rocket.getTime()<circuitTime && rocket.getTank().getCurrentGasoline()>0 && rocket.getDistance()<circuitLength)
				resultString+=rocket.updateValues(circuitLength);
			results.add(getFinalResult(rocket));
		}
		sortList(results);
		ResultController rc= new ResultController();
		try {
			rc.createResult(new ResultDto(results.get(0)));
		}catch(Exception e) {
			if(rc.getResult(circuitName).getTime()<results.get(0).getTime())
				rc.updateResult(circuitName, new ResultDto(results.get(0)));
		}
		return resultString+getResults(results);
	}
	
    private static List<Result> sortList (List<Result> input) {
		Collections.sort(input, new Comparator<Result>() {
		    public int compare(Result left, Result right)  {
		    	if(left.getTime()<0) {
		    		return (int)right.getTime();
		    	}
		    	else if((right.getTime()<0)) 
		    		return (int)right.getTime();

		        return (int)left.getTime() - (int)right.getTime();
		    }
		});
		return input;
    }
	
	public String getResults(List<Result> results) {
		String resultString = "";
		results = sortList(results);
		resultString+="\n"+"\n"+Result.isThereWinner(results) + "Results of the race:";
		for (int i = 0; i< results.size(); i++)
			resultString+="\n"+(i+1) + ". " + results.get(i).getRocketName() + " with a time of: " +  results.get(i).getTimeString();
		return resultString;
	}
	
	public Result getFinalResult (Rocket rocket) throws Exception {
		if (rocket.getTank().getCurrentGasoline()==0 || rocket.getTime()>=circuitTime)
			return new Result(this.getCircuitName(), -1, rocket.getName());//rocket has unfinished the race
		else
			return new Result(this.circuitName, rocket.getTime(),rocket.getName());
	}
}