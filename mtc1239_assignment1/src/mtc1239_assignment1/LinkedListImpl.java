package mtc1239_assignment1;

import org.omg.CORBA.Current;

public class LinkedListImpl implements LIST_Interface {
	Node sentinel; // this will be the entry point to your linked list (the head)

	public LinkedListImpl() {// this constructor is needed for testing purposes. Please don't modify!
		sentinel = new Node(0); 
		sentinel.next = sentinel;
		sentinel.prev = sentinel;// Note that the root's data is not a true part of your data set!
	}

	// implement all methods in interface, and include the getRoot method we made
	// for testing purposes. Feel free to implement private helper methods!

	public Node getRoot() { // leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

	@Override
	public boolean insert(double elt, int index) {
		Node temp = new Node(elt);
		if (index < 0 || index > size()) {
			return false;
		} else {
			Node current = sentinel;

			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			if (current.next != null) {
				Node next = current.next;
				current.next.prev = temp;
				current.next = temp;
				temp.next = next;
				temp.prev = current;
				return true;
			}
			return false;
		}

	}

	@Override
	public boolean remove(int index) {
		if (index > size() - 1) {
			return false;
		} else {
			Node current = sentinel;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			current.next = current.next.next;
			return true;
		}
	}

	@Override
	public double get(int index) {
		if (index > size() - 1) {
			return Double.NaN;
		} else {
			Node current = sentinel;
			for (int i = -1; i < index; i++) {
				current = current.next;
			}
			return current.data;
		}
	}

	@Override
	public int size() {
		int size = 0;

		if (sentinel.next == sentinel) {
			return size;
		} else {
			Node current = sentinel;
			if (current.next != null) {
				while (current.next != sentinel) {
					current = current.next;
					size++;
				}
			}
			return size;
		}
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}

}
