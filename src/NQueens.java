import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/n-queens/
 *
 */

public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        char[][] solution = new char[n][n];
        
        //init to '.'
        for(int i =0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		solution[i][j] = '.';
        	}
        }
        
        Integer iw = new Integer(0);
        
        solveNQueens(solution, 1, n, result);
        
        
        return result;
    }
    
    
   //solution[row-1][col-1] = 'Q';
    private boolean valid(char[][] solution, int row, int col, int n) {
    	boolean result = true;
    	
    	//col
			for (int i = 0; i < row-1; i++) {
				if (solution[i][col-1] == 'Q') {
					result = false;
					break;
				}
			}
		
		//direction '\'
		
		for(int i=2;(row-i>=0) && (col-i>=0);i++) {
				if(solution[row-i][col-i] == 'Q') {
					result = false;
					break;

			}
		}
		
		// direction '/'
		for(int i=2;(row-i>=0) && (col-2+i<n);i++) {
				if(solution[row-i][col-2+i] == 'Q') {
					result = false;
					break;

			}
		}
    	
    	return result;
    }
    
    private void solveNQueens(char[][] solution, int row, int n, List<String[]> result) {
    	for(int i=0;i<n;i++) {
    		solution[row-1][i] = 'Q';
    		if(this.valid(solution, row, i+1, n)) {
    			if(row == n) {
    				String[] matrix = new String[n];
    				for(int j=0;j<n;j++) {
    					matrix[j] = new String(solution[j]);
    				}
    				result.add(matrix);
    				
    			}else {
    				 solveNQueens(solution, row+1, n, result);
    			}
    		}
    		solution[row-1][i] = '.';
    	}
    }
}