
/*
 * https://oj.leetcode.com/problems/candy/
 */

public class Candy {
    public int candy(int[] ratings) {
    	int result = 1;
    	
    	int incLength = 0;
    	boolean inc = false;
    	boolean dec = false;
    	int decLength = 0;
    	boolean findPeak = false;
    	if(ratings.length > 1) {
    		inc = (ratings[1] - ratings[0]) > 0;
    		dec = !inc;
    		incLength = inc ? 2: 0;
    		decLength = dec ? 2 : 0;
	    	for(int i=2;i<ratings.length;i++) {
	    		//look for ^
	    		if(inc) {
	    			if((ratings[i] - ratings[i-1] < 0)) {
	    				findPeak = true;
	    				dec = true;
	    				decLength = 2;
	    			}else {
	    				incLength ++;
	    			}
	    		}else {
	    			if((ratings[i] - ratings[i-1] < 0)) {
	    				findPeak = true;
	    				dec = true;
	    				decLength = 2;
	    			}else {
	    				incLength ++;
	    			}
	    		}
	    	}
    	}
    	return result;
    	
    }
}