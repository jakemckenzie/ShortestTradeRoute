import java.util.ArrayList;
import java.util.List;
public class Node {
    int node;
    List<Edge> paths;
    boolean visited;
    int cost;
    Node interior;
    public Node(int node) {
        visited = false;
        cost = 0x7FFFFFFF;
        this.node = node;
        paths = new ArrayList<Edge>();
        interior = null;
    }
    public void edgeLabeling(Node destination, int weight) {
        if (!this.equals(destination)) {
            Edge e = new Edge(this, destination, weight);
            paths.add(e);
        }
    } 
}