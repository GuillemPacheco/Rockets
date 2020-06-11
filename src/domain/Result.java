package domain;
import java.util.List;

import application.resController;
import application.ResultDto;
import utilities.InvalidParamException;

public class Result{
    private String rocketName;
    private String circuitName;
    private int time;

    public Result (String circuitName, int time, String rocketName) throws Exception {
		if(circuitName == null || circuitName.equals(""))
			throw new Exception("The circuit name is not correct");
		if(rocketName == null || rocketName.equals(""))
			throw new Exception("The rocket name is not correct");
		if(time<-1)
			throw new Exception("The time cannot under or equal 0");
    	this.rocketName = rocketName;
    	this.time = time;
    	this.circuitName = circuitName;
    }
    
    public Result (ResultDto result) throws InvalidParamException {
		if(result==null) throw new InvalidParamException();
    	this.rocketName = result.getRocketName();
    	this.time = result.getTime();
    	this.circuitName = result.getCircuitName();
    }
    public int getTime() {
    	return time;
    }
    
    public String getRocketName() {
		return rocketName;
	}

	public String getCircuitName() {
		return circuitName;
	}

	public String getTimeString () {
    	if (time==-1)
    		return "unfinished";
    	else
    		return Integer.toString(time);
    }
    
    public static String isThereWinner (List<Result> input) {
    	for (Result r : input) {
    		if (r.getTime()>0)
    			return "There is a winner. ";
    	}
    	return "There is no winner. ";
    }

	public void updateResult(ResultDto resultdto) throws Exception {
		this.rocketName = resultdto.getRocketName();
    	this.time = resultdto.getTime();
    	this.circuitName = resultdto.getCircuitName();
		resController.updateResult(rocketName,time,circuitName);
	}
}