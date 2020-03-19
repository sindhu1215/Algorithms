public class LinkedListData {

	static SinglyLinkedListNode head;

	static class SinglyLinkedListNode {

		int data;
		SinglyLinkedListNode next = null;

		SinglyLinkedListNode(int data) {
			this.data = data;
		}
	}

	public SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data,
			int position) {
		SinglyLinkedListNode n = head;
		int pos = 0;
		while (n.next != null) {
			pos++;
			if (pos == position) {
				int temp = n.next.data;
				n.next.data = data;

			}
			n = n.next;
		}
		return head;
	}
	
	SinglyLinkedListNode insertNth(SinglyLinkedListNode head, int data, int position) {
		SinglyLinkedListNode dummy = new SinglyLinkedListNode(data);
	    dummy.next = head;

	    SinglyLinkedListNode runner = dummy;
	    for (int i = 0; i < position; ++i) {
	        runner = runner.next;
	    }

	    SinglyLinkedListNode node = new SinglyLinkedListNode(data);
	    node.data = data;
	    node.next = runner.next;
	    runner.next = node;

	    return dummy.next;
	}
	
	public void printList(SinglyLinkedListNode node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    }
	
	public SinglyLinkedListNode partitionList(SinglyLinkedListNode head, int x) {
		
		// before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
		SinglyLinkedListNode beforeStart = null;
		SinglyLinkedListNode beforeEnd = null;
		
		SinglyLinkedListNode afterStart = null;
		SinglyLinkedListNode afterEnd = null;
		
		
		// If the original list node is lesser than the given x,
        // assign it to the before list.
		while(head != null) {
			SinglyLinkedListNode next = head.next;
			if(head.data < x) {
				//insert node into end of before list
				if(beforeStart == null) {
					beforeStart = head;
					beforeEnd = beforeStart;
				}else {
					beforeEnd.next = head;
					beforeEnd = head;
				}
				
			} else {
				
				//insert node into end of after list
				if(afterStart == null) {
					afterStart = head;
					afterEnd = afterStart;
				}else {
					afterEnd.next = head;
					afterEnd = head;
				}
			}
			// move ahead in the original list
			head = next;
		}
		
		 if(beforeStart == null)
			 return afterStart;
		 
		 /* Merge before list to after list*/
		 beforeEnd.next = afterStart;
		 return beforeStart;
	}
	
	public SinglyLinkedListNode partitionListII(SinglyLinkedListNode node, int x) {
		SinglyLinkedListNode heads  = node;
		SinglyLinkedListNode tail = node;
		
		while(node != null) {
			SinglyLinkedListNode next = node.next;
			if(node.data < x) {
				node.next = heads;
				heads = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return heads;
	}
	
	public SinglyLinkedListNode addList(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
		return addLists(l1,l2,0);
	}
	
	SinglyLinkedListNode addLists(SinglyLinkedListNode l1,SinglyLinkedListNode l2, int carry){
		SinglyLinkedListNode result = new SinglyLinkedListNode(0);
		if(l1 == null && l2 == null && carry == 0 ) {
			return null;
		}
		
		int value = carry;
		if(l1 != null)
			value += l1.data;
		
		if(l2 != null)
			value += l2.data;
		
		result.data = value%10;//after neglecting the carry
		
		//Recursion
		if(l1 != null || l2 != null) {
			
		}
		return result;
	}

	public static void main(String[] args) {
		SinglyLinkedListNode list = new SinglyLinkedListNode(0);
		LinkedListData data = new LinkedListData();
		list.next = new SinglyLinkedListNode(1);
		list.next = new SinglyLinkedListNode(4);
		list.next.next = new SinglyLinkedListNode(3);
		list.next.next.next = new SinglyLinkedListNode(2);
		list.next.next.next.next = new SinglyLinkedListNode(5);
		list.next.next.next.next.next = new SinglyLinkedListNode(2);
		list.next.next.next.next.next.next = new SinglyLinkedListNode(6);

		System.out.println("Linked List before removing duplicates : \n ");
		data.printList(list);

		SinglyLinkedListNode result = data.partitionListII(list,4);
		System.out.println("");
		System.out.println("Linked List after removing duplicates : \n ");
		data.printList(result);
	}

}

