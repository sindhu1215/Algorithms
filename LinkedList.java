import java.util.HashSet;
import java.util.Set;

public class LinkedList  
{ 
    static class node  
    { 
        int val; 
        node next; 
  
        public node(int val)  
        { 
            this.val = val; 
            next = null;
        } 
    } 
      
    /* Function to remove duplicates from a 
       unsorted linked list */
    static void removeDuplicate(node head)  
    { 
        Set<Integer> set = new HashSet<>();
        node current = head;
        node prev = null;
        while(current != null) {
        	int curVal = current.val;
        	if(set.contains(curVal)) {
        		prev.next = current.next;
        	} else {
        		set.add(curVal);
        		prev = current;
        	}
        	  current = current.next;
        }
      
    }
    
    public int findKthElement(node head, int k) {
    	node current = head;
    	int size = 1;
    	while(current.next != null) {
    		size++;
    		current = current.next;
    	}
    	
    	current = head;
    	if(size < k) return 0;
    	int elementPos = size - k+1;
    	int elementToFind = 0;
    	int pos = 0;
    	
    	while(current.next != null) {
    		pos++;
    		if(pos == elementPos) {
    			elementToFind = current.val;
    			return elementToFind;
    		}
    		current = current.next;
    	}
    	
		return elementToFind;
    	
    }
    
    public int kthByIteration(node head, int k){
		if(head==null){
			return 0;
		}
		node curr = head;
		while(k>0){
			curr=curr.next;
			k--;
		}
		node sec = head;
		while(curr!=null){
			curr = curr.next;
			sec = sec.next;
		}
		int i  = sec.val;
		return i;
	}
    
    public node deleteMiddleNode(node head) {
    	node n = head;
    	int nodeToDelete = 0;
    	int target = 1;
    	int size = 1;
    	while(n.next != null) {
    		size++;
    		n = n.next;
    	}
    	
    		nodeToDelete = size/2 + 1;
   
    	
    	node m = head;
    	while(m.next != null) {
    		target++;
    		
    		
    		if(target == nodeToDelete) {
    			m.next = m.next.next;
    			return head;
    		}
    		m = m.next;
    	} 
    	
    	return head;
    	
    }
    
    public node partitionList(node head, int x) {
    	node smallerList = new node(0);
    	node small = smallerList;
    	node greaterList = new node(0);
    	node great = greaterList;
    	while(head.next != null) {
    		if(head.next.val < x) {
    			small.next = head;
    			small = small.next;
    		} else {
    			great.next = head;
    			great = great.next;
    		}
    		head = head.next;
    	}
    	
    	great.next = null;
    	small.next = greaterList.next;
    	
    	return smallerList.next;
    	
    }
    
    public node sumLists(node l1,node l2) {
    	node result = null;
    	node prev = null;
    	node temp = null;
    	int carry=0,sum;
    	
    	while(l1 != null || l2 != null) {
    		
    		//adding the first element + second element + carry
    		sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
    		
    		//update the carry for next sum
    		carry = (sum >= 10) ? 1 :0;
    		
    		//update sum if it is > 10
    		sum = sum%10;
    		
    		temp = new node(sum);
    		
    		if(result == null) {
    			result = temp;
    		} else {
    			prev.next = temp;
    		}
    		
    		prev = temp;
    		
    		// Move first and second pointers to next nodes 
            if (l1 != null) { 
                l1 = l1.next; 
            } 
            if (l2 != null) { 
                l2 = l2.next; 
            }
            
        } 
  
        if (carry > 0) { 
            temp.next = new node(carry); 
        } 
  
        // return head of the resultant list 
        return result;
    	}
    
    public node sumList(node l1, node l2, int carry) {
    	if(l1==null && l2==null && carry==0 ) return null;
    	
    	node result = new node(0);
    	int value = carry;
    	if(l1 != null) value += l1.val;
    	if(l2 != null) value += l2.val;
    	
    	result.val = value%10;//saving the remainder value as the first digit
    	
    	if(l1 != null || l2 != null) {
    		node n = sumList(l1 != null ? l1.next : null, l2 != null ? l2.next : null, value >= 10 ? 1: 0 );
    		
    		while(result != null) {
        		result.next = n;
        		result = result.next;
        	}
    		
    	}
    	
    	return result;
    	
    }
    
    public int getIntersectingNode(node l1,node l2) {
    	int c1 = getSize(l1);
    	int c2 = getSize(l2);
    	int result = -1;
    	int d = Math.abs(c1-c2);
    	if(c1 > c2) {
    		result = getIntersectionNode(d,l1,l2);
    	}else {
    		result = getIntersectionNode(d,l2,l1);
    	}
		return result;
    }
    
    public int getIntersectionNode(int d, node l1, node l2) {
    	for(int i=0;i <d ;i++) {
    		if(l1 == null)
    			return -1;
    		
    		l1 = l1.next;
    	}
    	
    	while(l1 != null && l2 != null) {
    		if(l1.val == l2.val) {
    			return l1.val;
    		}
    		l1= l1.next;
    		l2 = l2.next;
    	}
    	return -1;
    }
    
    public int getSize(node Node) {
    	int size = 0 ;
    	while(Node != null) {
    		size++;
    		Node = Node.next;
    	}
    	
    	return size;
    }
      
    /* Function to print nodes in a given linked list */
    static void printList(node head)  
    { 
        while (head != null)  
        { 
            System.out.print(head.val + " "); 
            head = head.next; 
        } 
    } 
  
    public static void main(String[] args)  
    { 
    	LinkedList list = new LinkedList();
        node start = new node(10); 
        start.next = new node(12); 
        start.next.next = new node(7); 
        start.next.next.next = new node(9); 
        start.next.next.next.next = new node(2); 
        start.next.next.next.next.next = new node(5); 
        start.next.next.next.next.next.next = new node(8); 
        start.next.next.next.next.next.next.next = new node(6); 
        
        node l1 = new node(3); 
        l1.next = new node(1); 
        l1.next.next = new node(5);
        l1.next.next.next = new node(9);
        l1.next.next.next.next = new node(7);
        l1.next.next.next.next.next = new node(2);
        l1.next.next.next.next.next.next = new node(1);
        
        node l2 = new node(4); 
        l2.next = new node(6); 
        l2.next.next = new node(7);
        l2.next.next.next = new node(2);
        l2.next.next.next.next = new node(1);
    
        
        
        
        
        System.out.println("Linked list before removing duplicates :"); 
  
        list.printList(l1); 
        list.printList(l2); 
        System.out.println("Linked list before removing duplicates :");
        int result = list.getIntersectingNode(l1, l2);
        System.out.println("Result: "+result);
  
    } 
} 
  