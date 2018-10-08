package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;
	}

	@Override
	// used for testing, please leave as is
	public BST_Node getRoot() {
		return root;
	}

	@Override
	public boolean insert(String s) {
		if (empty()) {
//			System.out.println("making a new tree, first node " + s);
			root = new BST_Node(s);
			root.parent = null;
			size++;
			return true;
		} else if (contains(s)) {
			return false;
		} else {
			size++;
			return root.insertNode(s);
		}
	}

	@Override
	public boolean remove(String s) {
		if (empty()) {
			return false;
		} else if (!contains(s)) {
			return false;
		} else if (root.getData().equals(s)) {
			if (root.getLeft() == null && root.getRight() == null) {
				root = null;
				size = 0;
				return true;
			} else if (root.getLeft() != null && root.getRight() == null) {
				String tempData = root.getLeft().findMax().getData();
				remove(tempData);
				root.data = tempData;
				return true;
			} else if (root.getLeft() == null && root.getRight() != null) {
				String tempData = root.getRight().findMin().getData();
				remove(tempData);
				root.data = tempData;
				return true;
			} else {
				String tempMax = root.getLeft().findMax().data;
				remove(tempMax);
				root.data = tempMax;
				return true;
			}
		} else {
			size--;
			return root.removeNode(s);
		}
	}

	@Override
	public String findMin() {
		if (empty()) {
			return null;
		} else {
			return root.findMin().getData();
		}
	}

	@Override
	public String findMax() {
		if (empty()) {
			return null;
		} else {
			return root.findMax().getData();
		}
	}

	@Override
	public boolean empty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		if (empty()) {
			return false;
		} else if (root.getData().equals(s)) {
			return true;
		} else {
			return root.containsNode(s);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {
		if (empty()) {
			return -1;
		} else {
			return root.getHeight();
		}
	}

}