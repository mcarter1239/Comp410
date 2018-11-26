package DiGraph_A5;
import java.util.*;

public class Node {

	private long idNum;
	private String label;
	private ArrayList<Edge> inEdges;
	private ArrayList<Edge> outEdges;
	private DiGraph graph;

	public Node(long idNum, String label, DiGraph graph) {
		this.idNum = idNum;
		this.label = label;
		this.graph = graph;
	}

	public void delNode() {
		for(int i = 0; i < inEdges.size(); i++) {
			graph.delEdge(inEdges.get(i).sLabel, inEdges.get(i).dLabel);
		}
		for(int i = 0; i < outEdges.size(); i++) {
			graph.delEdge(outEdges.get(i).sLabel, outEdges.get(i).dLabel);
		}
	}
}
