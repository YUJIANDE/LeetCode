import java.util.Stack;

public class EvalRPN {
	
	private final String[] ops = {"+", "-", "*", "/"};
	
	public boolean isOperator(String op){
		boolean result = false;
		for(int i=0;i<ops.length;i++){
			if(ops[i].equals(op)){
				result = true;
				break;
			}
		}
		return result;
	}
	
    public int evalRPN(String[] tokens) {
    	
    	Stack<String> stack = new Stack<String>();
    	
    	for(int i=0; i<tokens.length;i++){
    		String token = tokens[i];
    		if(!this.isOperator(token)){
    			stack.push(token);
    		}else{
    			String op2 = stack.pop();
    			String op1 = stack.pop();
    			
    			if(token.equals("+")){
    				stack.push(String.valueOf((Integer.valueOf(op1) + Integer.valueOf(op2))));
    			}else if(token.equals("-")){
    				stack.push(String.valueOf((Integer.valueOf(op1) - Integer.valueOf(op2))));
    			}else if(token.equals("*")){
    				stack.push(String.valueOf((Integer.valueOf(op1) * Integer.valueOf(op2))));
    			}else{
    				stack.push(String.valueOf((Integer.valueOf(op1) / Integer.valueOf(op2))));
    			}
    		}
    	}
    	
    	
    	
    	
        return Integer.valueOf(stack.peek());
    }
}