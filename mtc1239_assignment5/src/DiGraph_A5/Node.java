package DiGraph_A5;

import java.util.*;
import java.util.Map.Entry;

public class Node {

	long idNum;
	String label;
	HashMap<String, Edge> inEdges = new HashMap<String, Edge>();
	HashMap<String, Edge> outEdges = new HashMap<String, Edge>();
	Edge loop = null;
	DiGraph graph;

	public Node(long idNum, String label, DiGraph graph) {
		this.idNum = idNum;
		this.label = label;
		this.graph = graph;
	}

	public void delNode() {
		if (loop != null) {
			graph.delEdge(label, label);
		}

		Iterator<Map.Entry<String, Edge>> entries = inEdges.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<String, Edge> entry = entries.next();
			graph.delEdge(entry.getValue().sLabel, entry.getValue().sLabel);
		}
		entries = outEdges.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<String, Edge> entry = entries.next();
			graph.delEdge(entry.getValue().sLabel, entry.getValue().sLabel);
		}
	}

	public void addInEdge(String s, Edge e) {
		inEdges.put(s, e);
	}

	public void addOutEdge(String d, Edge e) {
		outEdges.put(d, e);
	}

	public void addLoop(Edge e) {
		loop = e;
	}

	public void removeOutEdge(String d) {

	}

	public void removeInEdge(String s) {

	}

	public void removeLoop() {
		loop = null;
	}
}
