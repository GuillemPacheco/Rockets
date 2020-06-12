package domain;

import java.util.List;

import application.RaceController;

import java.util.ArrayList;

import view.Main;

public class Strategy {

	List<Integer> bestStrategy = new ArrayList<Integer>();
	int bestTime = 999;
	
	void generateCombinations(int len, int arr[], int n, Rocket r, Circuit c) throws Exception { 
        if (len == 1) {
    		List<Integer> teststrategy = new ArrayList<Integer>() {{ for (int i : arr) add(i); }};
    		int time = getTimeToComplete(r,c,teststrategy);
        	if (time<bestTime && time!=-1) {
        		bestStrategy = teststrategy;
        		bestTime = time;
        	}	
        }
        for (int i=0; i<len; i++) { 
        	generateCombinations(len-1,arr, n,r,c); 
            if (len % 2 == 1) { 
                int tmp = arr[0]; 
                arr[0] = arr[len-1]; 
                arr[len-1] = tmp; 
            } 
            else { 
                int tmp = arr[i]; 
                arr[i] = arr[len-1]; 
                arr[len-1] = tmp; 
            } 
        } 
    } 
    
	public static int[] getArray (int length, int jumps) {
		int a[] = new int[length];
		a[0] = 1;
		for (int i = 1; i<a.length;i++)
			a[i] = a[i-1]+jumps;
		
		return a;
	}
	public Strategy (Rocket r, Circuit c) throws Exception{
		bestTime = 999;
        int arr[] = getArray(11,5);
        generateCombinations(arr.length,arr, arr.length, r,c); 
        RaceController.updateBar();
	}
	
	public int getTimeToComplete (Rocket r, Circuit c, List<Integer> strategy) throws Exception {
		r.resetRocket();
		while(r.getTime()<c.getCircuitTime() && r.getTank().getCurrentGasoline()>0 && r.getDistance()<c.getCircuitLength())
			r.updateValues(c.getCircuitLength(), strategy);
		
		if (r.getTank().getCurrentGasoline()==0 || r.getTime()>=c.getCircuitTime())
			return -1;
		else
			return r.getTime();	
	}
}