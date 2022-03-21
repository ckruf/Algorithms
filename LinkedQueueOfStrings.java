
public class LinkedQueueOfStrings {
	
	private Node first;
	private Node last;
	
	private class Node {
		String item;
		Node next;
	}
	
	public boolean IsEmpty() {
		return first == null;
	}
	
	public String dequeue() throws Exception {
		if (first == null) throw new Exception("Queue is empty");
		String item = first.item;
		first = first.next;
		// If the queue is empty after dequeueing the one last item,
		// the 'first' pointer is now null (since it has been set to first.next
		// and first.next will be null for the last remaining item). The 'last'
		// pointer is however still pointing to the one item, so we need to 
		// set it to null, since we now have no items in the queue
		if (IsEmpty()) last = null;
		return item;
	}
	
	public void enqueue(String item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		// If the queue is empty, the 'first' pointer is null
		// therefore, the 'last' Node which we just created
		// is also the first, and so the 'first' pointer
		// should point to the same (and only) item as the 'last'
		if (IsEmpty()) first = last;
		else oldlast.next = last;
	}
	
}
