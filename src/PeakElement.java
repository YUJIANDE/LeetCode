public class PeakElement {
    public int findPeakElement(int[] num) {
        int result = 0;
        int start = 0, end = num.length;
        int m = (start + end) / 2;
        while(end >= start){

		    if(start == end){
		    	result = start;
		    	break;
		    }

		    if(start + 1 == end){
		    	result = (num[start] > num[end]) ? start : end;
		    	break;
		    }

		    if(num[m] > num[m-1] && num[m] > num[m+1]){
		    	result = m;
		    	break;
		    }else if(num[m] > num[m-1] && num[m] <num[m+1]){
		    	start = m+1;
		    } else{
		    	end = m;
		    }

        }
        return result;
    }
}