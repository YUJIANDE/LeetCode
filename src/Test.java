
public class Test {

	public static void main(String[] args) {
//		String[] t = {"4", "13", "5", "/", "+"};
//		new Test().testEvalRPN(t);
//		new Test().testLRUCache();
//		int[] input = {1, 2};
//		new Test().testReorderList(input);
		new Test().testCandy();
	}
	
	void testReverseWords(){
		System.out.println("result: [" + ReverseWords.reverseWords(" a b  cv j") + "]");
	}
	/**
	 *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 */
	
	void testEvalRPN(String[] tokens){
		System.out.println(new EvalRPN().evalRPN(tokens));
	}
	
	void testLRUCache(){
		LRUCache cache= new LRUCache(3);
		cache.get(1);
		cache.set(1, 11);
		cache.set(2, 22);
		cache.set(3, 33);
		cache.set(4, 44);
		cache.set(5, 55);
	}
	void testReorderList(int[] input) {
		ListNode head = new ListNode(input[0]);
		ListNode p = head;
		for(int i=1;i<input.length;i++) {
			p.next = new ListNode(input[i]);
			p = p.next;
		}
		new ReorderList().reorderList(head);
		
		p = head;
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
	
	void testCandy() {
		Candy candy = new Candy();
		int[] input = {1, 3, 4, 3, 2, 1};
		System.out.println(candy.candy(input));
	}

}
