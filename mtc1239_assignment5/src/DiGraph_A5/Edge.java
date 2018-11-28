package DiGraph_A5;

public class Edge {

	long idNum;
	String sLabel;
	String dLabel;
	long weight;
	String eLabel;

	public Edge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		this.idNum = idNum;
		this.sLabel = sLabel;
		this.dLabel = dLabel;
		this.weight = weight;
		this.eLabel = eLabel;
	}
}
