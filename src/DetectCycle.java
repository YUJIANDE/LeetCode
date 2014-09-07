/**
 * 
https://oj.leetcode.com/problems/linked-list-cycle-ii/ *
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode result = null;
        
       ListNode catchNode =  LinkedListCycle.hasCycle(head);
       if(catchNode != null) {
    	  ListNode head2 = catchNode.next;
    	  int len1 = countNodes(head, catchNode)+1,
    		  len2 = countNodes(head2, catchNode)+1,
    		  diff = Math.abs(len2- len1);
    	  
    	  if(len1 > len2) {
    		  for (int i=0; i< diff; i++) {
    			  head = head.next;
    		  }
    	  }else {
    		  for (int i=0; i< diff; i++) {
    			  head2 = head2.next;
    		  }
    	  }
    	  
    	  while(head != head2) {
    		  head = head.next;
    		  head2 = head2.next;
    	  }
    	  result = head;
    	  
       }
        
        return result;
    }
    
    private int countNodes(ListNode head, ListNode tail) {
    	int len = 0;
    	ListNode p = head;
    	while(p != tail) {
    		p = p.next;
    		len++;
    	}
    	
    	return len;
    }
}