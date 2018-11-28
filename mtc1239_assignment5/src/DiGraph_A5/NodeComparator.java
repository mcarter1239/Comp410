package DiGraph_A5;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node n1, Node n2) {
		if (n1.distance > n2.distance) {
			return 1;
		} else if (n1.distance < n2.distance) {
			return -1;
		}
		return 0;
	}
}
