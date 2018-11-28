package DiGraph_A5;

public class DiGraphPlayground {

	public static void main(String[] args) {

		// thorough testing is your responsibility
		//
		// you may wish to create methods like
		// -- print
		// -- sort
		// -- random fill
		// -- etc.
		// in order to convince yourself your code is producing
		// the correct behavior
		exTest();
	}

	public static void exTest() {
		DiGraph d = new DiGraph();
		d.addNode(1, "p");
		d.addNode(3, "a");
		d.addNode(7, "g");
		d.addNode(0, "e");
		d.addEdge(0, "p", "a",10, null);
		d.addEdge(1, "a", "g",12, null);
		d.addEdge(2, "g", "e",1, null);
		d.addEdge(3, "e", "p",6, null);
		d.addEdge(4, "p", "g",4, null);
		d.addEdge(5, "a", "e",100, null);
		d.addEdge(6, "a", "p",9, null);
		d.addEdge(7, "e", "a",3, null);
		d.addEdge(8, "g", "a",15, null);
		d.addEdge(9, "p", "e",8, null);
		d.addEdge(10, "g", "p",2, null);
		System.out.println("numEdges: " + d.numEdges());
		System.out.println("numNodes: " + d.numNodes());
		ShortestPathInfo[] l = d.shortestPath("p");
		for(int i = 0; i < l.length; i++) {
			System.out.println(l[i].toString());
		}
	}
}