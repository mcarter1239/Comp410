package mtc1239_assignment1;

public class LinkedListImpl implements LIST_Interface {
	Node sentinel; // this will be the entry point to your linked list (the head)
	
	public LinkedListImpl() {// this constructor is needed for testing purposes. Please don't modify!
		sentinel = new Node(0); // Note that the root's data is not a true part of your data set!
	}

	// implement all methods in interface, and include the getRoot method we made
	// for testing purposes. Feel free to implement private helper methods!

	public Node getRoot() { // leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

	@Override
	public boolean insert(double elt, int index) {
		Node temp = new Node(elt);
		if(index < 0 || index > this.size()) {
			return false;
		} else if (this.size() == 0) {
			sentinel.next = temp;
			sentinel.prev = temp;
			
			return true;
		} else {
			
			
			return true;
		}
		
		
	}

	@Override
	public boolean remove(int index) {
		
	}

	@Override
	public double get(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		int size = 0;
		
		if(sentinel.next == sentinel) {
			return size;
		} else {
			Node current = sentinel;
			while(current.next != sentinel) {
				current = current.next;
				size++;
			}
			return size;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}
	
	public Node retrieve(int index) {
		
	}
}
