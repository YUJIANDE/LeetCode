import java.util.Stack;


public class ValidParentheses {

    public boolean isValid(String s) {
        boolean result = true;
        Stack<String> stack = new Stack<String>();
        
        for(int i=0;i<s.length(); i++) {
        	String c = s.substring(i, i+1);
        	if(c.equals("(") || c.equals("{") || c.equals("[")) {
        		stack.push(c);
        	}else {
        		if(!stack.isEmpty()) {
	        		String pop = stack.pop();
	        		if(c.equals(")") && pop.equals("(") || (c.equals("}") && pop.equals("{")) || (c.equals("]") && pop.equals("["))) {
	        			continue;
	        		}
        		}
        		result = false;
        		break;
        	}
        }
        if(result) {
        	result = stack.isEmpty();
        }
        
        return result;
    }
}
