import java.util.List;

/*
 * https://oj.leetcode.com/problems/triangle/
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = 0;
        int count = triangle.size();
        int[] preSum = new int[count];
        int[] sum = new int[count];
        
        preSum[0] = sum[0];
        for(int i=1;i<count;i++) {
        	List<Integer> row = triangle.get(i);
        	int len = row.size();// len = i+1;
        	sum[0] = preSum[0] + row.get(0);
        	for(int j=1;j<len-1;j++) {
        		sum[j] = Math.min(preSum[j-1] + row.get(j) , preSum[j]+ row.get(j));
        	}
        	sum[len-1] = row.get(len-1) + preSum[len-2];
        	//store previous calculated array
        	for(int j=0;j<len;j++){
        	    preSum[j] = sum[j];
        	}
        }
        
        result = sum[0];
        for(int i=0;i<count;i++) {
        	if(sum[i] < result) {
        		result = sum[i];
        	}
        }
        
        return result;
    }
}