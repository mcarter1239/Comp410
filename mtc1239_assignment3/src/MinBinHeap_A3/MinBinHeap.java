package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; // load this array
	private int size;
	private int last;
	private static final int arraySize = 10000; // Everything in the array will initially
												// be null. This is ok! Just build out
												// from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); // 0th will be unused for simplicity
													// of child/parent computations...
													// the book/animation page both do this.
	}

	// Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public EntryPair[] getHeap() {
		return this.array;
	}

	@Override
	public void insert(EntryPair entry) {
		this.last++;
		this.array[this.last] = entry;
		int n = this.last;
		int p = this.PN(n);
		EntryPair temp;
		while ((p != 0) && (entry.priority < this.array[p].priority)) {
			temp = this.array[n];
			this.array[n] = this.array[p];
			this.array[p] = temp;
			n = p;
			p = this.PN(n);
		}

	}

	@Override
	public void delMin() {
		if (this.size() == 0)
			return;
		if (this.size() == 1) {
			this.array[1] = null;
			this.last--;
			return;
		}
		this.array[1] = this.array[this.last];
		this.array[this.last] = null;
		this.last--;
		// bubble down from root
		EntryPair temp = null;
		boolean done = false;
		int n = 1;
		int c = 0;
		while (!done) {
			if (this.isLeaf(n)) {
				done = true;
			} else {
				if (this.hasOnlyLC(n)) {
					c = this.LC(n);
				} else {
					c = (this.LCV(n) < this.RCV(n)) ? this.LC(n) : this.RC(n);
				}
				if (this.array[n].priority > this.array[c].priority) {
					temp = this.array[c];
					this.array[c] = this.array[n];
					this.array[n] = temp;
					n = c;
				} else {
					done = true;
				}
			}
		}
	}

	@Override
	public EntryPair getMin() {
		return array[1];
	}

	@Override
	public int size() {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				return i - 1;
			}
		}
		return array.length - 1;
	}

	@Override
	public void build(EntryPair[] entries) {
		for (int i = 0; i < entries.length; i++) {
			array[i + 1] = entries[i];
		}
		this.last = entries.length;
		int sn = this.PN(last);
		for (int k = sn; k > 0; k--) {
			EntryPair temp = null;
			boolean done = false;
			int n = k;
			int c = 0;
			while (!done) {
				if (this.isLeaf(n)) {
					done = true;
				} else if (this.hasOnlyLC(n)) {
					c = this.LC(n);
				} else {
					c = (this.LCV(n) < this.RCV(n)) ? this.LC(n) : this.RC(n);
				}
				if (this.array[n].priority > this.array[c].priority) {
					temp = this.array[n];
					this.array[n] = this.array[c];
					this.array[c] = temp;
					n = c;
				} else {
					done = true;
				}

			}
		}
	}

	public int LC(int n) {
		return 2 * n;
	}

	public int RC(int n) {
		return (2 * n) + 1;
	}

	public int PN(int n) {
		return (int) Math.floor(n / 2);
	}

	public boolean hasOnlyLC(int n) {
		return (this.RC(n) > this.last && this.LC(n) <= this.last);
	}

	private boolean isLeaf(int n) {
		return (this.LC(n) > this.last && this.RC(n) > this.last);
	}

	private int RCV(int n) {
		return array[RC(n)].priority;
	}

	private int LCV(int n) {
		return array[LC(n)].priority;
	}

}