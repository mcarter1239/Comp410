package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;

	BST_Node(String data) {
		this.data = data;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	// --- end used for testing -------------------------------------------

	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	public BST_Node getParent() {
		return parent;
	}

	// done
	public boolean containsNode(String s) {
		if (getData().compareTo(s) == 0) {
			return true;
		} else if (getData().compareTo(s) > 0 && getLeft() != null) {
			return getLeft().containsNode(s);
		} else if (getData().compareTo(s) < 0 && getRight() != null) {
			return getRight().containsNode(s);
		}

		return false;
	}

	// done
	public boolean insertNode(String s) {
		if (getData().compareTo(s) > 0) {
			if (getLeft() != null) {
				return getLeft().insertNode(s);
			} else {
				this.left = new BST_Node(s);
				this.left.parent = this;
				return true;
			}
		} else {
			if (getRight() != null) {
				return getRight().insertNode(s);
			} else {
				this.right = new BST_Node(s);
				this.right.parent = this;
				return true;
			}
		}
	}

	public boolean removeNode(String s) {
		if (getData().compareTo(s) == 0) {
			if (getLeft() != null && getRight() == null) {
				getLeft().parent = this.parent;
				if (getData().compareTo(parent.getData()) < 0) {
					parent.left = getLeft();
				} else if (getData().compareTo(parent.getData()) > 0) {
					parent.right = getLeft();
				}
				return true;
			} else if (getLeft() == null && getRight() != null) {
				getRight().parent = this.parent;
				if (getData().compareTo(parent.getData()) < 0) {
					parent.left = getRight();
				} else if (getData().compareTo(parent.getData()) > 0) {
					parent.right = getRight();
				}
				return true;
			} else if (getLeft() == null && getRight() == null) {
				if (getData().compareTo(parent.getData()) < 0) {
					parent.left = null;
				} else if (getData().compareTo(parent.getData()) > 0) {
					parent.right = null;
				}
				return true;
			} else if (getLeft() != null && getRight() != null) {
				String tempData = getLeft().findMax().getData();
				removeNode(tempData);
				data = tempData;
				return true;
			}

		} else if (getData().compareTo(s) > 0 && getLeft() != null) {
			return getLeft().removeNode(s);
		} else if (getData().compareTo(s) < 0 && getRight() != null) {
			return getRight().removeNode(s);
		}

		return false;
	}

	// done
	public BST_Node findMin() {
		if (getLeft() != null) {
			return getLeft().findMin();
		} else {
			return this;
		}
	}

	// done
	public BST_Node findMax() {
		if (getRight() != null) {
			return getRight().findMax();
		} else {
			return this;
		}
	}

	// done
	public int getHeight() {
		if (getRight() != null && getLeft() != null) {
			return Math.max(getLeft().getHeight(), getRight().getHeight()) + 1;
		} else if (getRight() != null) {
			return getRight().getHeight() + 1;
		} else if (getLeft() != null) {
			return getLeft().getHeight() + 1;
		} else {
			return 0;
		}
	}

	// --- end fill in these methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ", Right: "
				+ ((this.right != null) ? right.data : "null") + ", Parent: "
						+ ((this.parent != null) ? parent.data : "null");
	}
}