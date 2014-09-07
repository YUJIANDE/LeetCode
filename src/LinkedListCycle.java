/*
 * https://oj.leetcode.com/problems/linked-list-cycle/
 */

public class LinkedListCycle {
    static public ListNode hasCycle(ListNode head) {
        ListNode result = null;
        
        ListNode fast = head, slow = head;
        
        while(fast != null && slow != null) {

        	fast = fast.next;
        	if(fast != null) {
        		fast = fast.next;
        	}
        	slow = slow.next;
        	
        	if((fast != null && slow != null) && fast == slow || (fast != null && (fast.next == slow))) {
        		result = slow;
        		break;
        	}
        }
        
        return result;
    }
}
