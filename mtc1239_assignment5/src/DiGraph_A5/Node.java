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
	long distance;
	boolean done;
	long num;

	public Node(long idNum, String label, DiGraph graph, long num) {
		this.idNum = idNum;
		this.label = label;
		this.graph = graph;
		this.num = num;
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
	public int numOutEdges() {
		int counter = 0;
		Iterator<Map.Entry<String, Edge>> entries = outEdges.entrySet().iterator();
		while (entries.hasNext()) {
			entries.next();
			counter++;
		}
		
		return counter;
	}
	public Edge[] getOutEdges() {
		int counter = 0;
		Edge[] output = new Edge[numOutEdges()];
		
		Iterator<Map.Entry<String, Edge>> entries = outEdges.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<String, Edge> entry = entries.next();
			output[counter] = entry.getValue();
			counter++;
		}
		return output;	
	}
}
