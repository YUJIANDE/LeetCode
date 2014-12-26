import java.util.ArrayList;
import java.util.List;

public class PhoneNumber2Strings {

	private String[] map  = {"", "", "abc", "def","ghi", "jkl","mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<String>();
    	if(digits.length() == 0){
    		result.add("");
    		return result;
    	}
    	int index = Integer.valueOf(digits.substring(0, 1));
    	String values = map[index];
		List<String> posts = letterCombinations(digits.substring(1));
    	for(int j=0;j<values.length();j++){
    		for(int k=0;k<posts.size();k++){
    			result.add(values.substring(j, j+1) + posts.get(k));
    		}
    	}
        return result;
    }
}