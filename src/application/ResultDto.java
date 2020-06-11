package application;
import domain.Result;

public class ResultDto {
	
    private String rocketName;
	private String circuitName;
    private int time;
    
    public ResultDto ( int time,String r) throws Exception {
     	this.rocketName = r;
     	this.time = time;
     }
    
    public ResultDto (Result result) throws Exception {
    	if(result.getCircuitName() == null || result.getCircuitName().equals(""))
			throw new Exception("The circuit name is not correct");
		if(result.getRocketName()  == null || result.getRocketName().equals(""))
			throw new Exception("The rocket name is not correct");
		if(result.getTime()<=0)
			throw new Exception("The time cannot under or equal 0");
    	this.rocketName = result.getRocketName();
    	this.time = result.getTime();
    	this.circuitName = result.getCircuitName();
    }
    
    public String getRocketName() {
		return rocketName;
	}

	public String getCircuitName() {
		return circuitName;
	}

	public int getTime() {
		return time;
	}

}
