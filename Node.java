import java.util.ArrayList;
import java.util.List;
public class Node {
    int node;
    List<Edge> paths;
    boolean visited;
    int cost;
    Node retrace;
    public Node(int node) {
        visited = false;
        cost = 0x7FFFFFFF;
        this.node = node;
        paths = new ArrayList<Edge>();
        retrace = null;
    }
    public void addEdge(Node destination, int weight) {
        if (!this.equals(destination)) {
            Edge e = new Edge(this, destination, weight);
            paths.add(e);
        }
    } 
}