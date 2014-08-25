/**
 * https://oj.leetcode.com/problems/reorder-list/
 * @author jiandeyu
 *
 */

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null) {
        	return;
        }
        
        //1. calculate list length
        int length = 0;
        ListNode p = head;
        while(p != null) {
        	p = p.next;
        	length++;
        }
        
        ListNode middle = head;
        ListNode tail = head;
        for(int i=0;i<length - length/2;i++) {
        	tail = middle;
        	middle = middle.next;
        }
        tail.next = null; //set tail.next to null
        
        if(middle != null) {
        	//2. reverse the 2nd half of the list
        	middle = reverseList(middle);
        	
        	//3. insert the 2nd half the list to the 1st half
        	p = head;
        	while(p!=null && middle != null) {
        		ListNode next = p.next;
        		ListNode middleNext = middle.next;
        		p.next = middle;
        		middle.next = next;
        		middle = middleNext;
        		p = next;
        	}
        	
        }
        
    }
    
    private ListNode reverseList(ListNode head) {
    	ListNode cur = head, pre=null, post = cur.next;
    	ListNode temp;
    	while(post != null) {
    		temp = post.next;
    		cur.next = pre;
    		post.next = cur;
    		pre = cur;
    		cur = post;
    		post = temp;
    	}
    	
    	return cur;
    }
    
}