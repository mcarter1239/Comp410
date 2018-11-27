package DiGraph_A5;

import java.util.*;

public class DiGraph implements DiGraphInterface {

	private HashMap<String, Node> nodes = new HashMap<String, Node>();
	private ArrayList<String> edges = new ArrayList<String>();
	private ArrayList<Long> edgeIDNums = new ArrayList<Long>();
	private ArrayList<Long> nodeIDNums = new ArrayList<Long>();
	private int numNodes = 0;

	public DiGraph() { // default constructor
		// explicitly include this
		// we need to have the default constructor
		// if you then write others, this one will still be there
	}

	@Override
	public boolean addNode(long idNum, String label) {
		if (idNum < 0 || nodeIDNums.contains(idNum)) {
			return false;
		}
		Node temp = new Node(idNum, label, this);
		if (nodes.get(label) == null) {
			nodes.put(label, temp);
			numNodes++;
			nodeIDNums.add(idNum);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		if (idNum < 0 || edgeIDNums.contains(idNum)) {
			return false;
		}

		if (nodes.containsKey(sLabel) && nodes.containsKey(dLabel) && !edges.contains(sLabel + dLabel)) {
			Edge temp = new Edge(idNum, sLabel, dLabel, weight, eLabel);
			edges.add(sLabel + dLabel);
			if (sLabel.equals(dLabel)) {
				nodes.get(sLabel).addLoop(temp);
			} else {
				nodes.get(dLabel).addInEdge(sLabel, temp);
				nodes.get(sLabel).addOutEdge(dLabel, temp);
			}
			edgeIDNums.add(idNum);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delNode(String label) {
		if (nodes.containsKey(label)) {
			nodeIDNums.remove(nodes.get(label).idNum);
			nodes.get(label).delNode();
			nodes.remove(label);
			numNodes--;
			
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		if (edges.contains(sLabel + dLabel)) {
			edgeIDNums.remove(nodes.get(sLabel).outEdges.get(dLabel).idNum);

			if (sLabel.equals(dLabel)) {
				nodes.get(sLabel).removeLoop();
				edges.remove(sLabel + dLabel);
				
			} else {
				nodes.get(sLabel).removeOutEdge(dLabel);
				nodes.get(dLabel).removeInEdge(sLabel);
				edges.remove(sLabel + dLabel);
				
			}
						return true;
		} else {
			return false;
		}
	}

	@Override
	public long numNodes() {
		return numNodes;
	}

	@Override
	public long numEdges() {
		return edges.size();
	}

	// rest of your code to implement the various operations
}
