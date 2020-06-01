package domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class result{
    private String name;
    private int time;
    
    public result (String name, int time) {
    	this.name = name;
    	this.time = time;
    }
    
    public int getTime() {
    	return time;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getTimeString () {
    	if (time==0)
    		return "unfinished";
    	else
    		return Integer.toString(time);
    }
    
    public static String isThereWinner (List<result> input) {
    	for (result r : input) {
    		if (r.getTime()>0) {
    			return "There is a winner. ";
    		}
    	}
    	return "There is no winner. ";
    }
    
    public static List<result> sortList (List<result> input) {
		Collections.sort(input, new Comparator<result>() {
		    public int compare(result left, result right)  {
		        return left.getTime() - right.getTime();
		    }
		});
		return input;
    }
}