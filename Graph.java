import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Graph{
    List<Node> V;
    List<Edge> E;
    public Graph(){
        V = new ArrayList<Node>();
        E = new ArrayList<Edge>();
    }
    /**
     * @param n
     */
    public void addNode(Node n){
        V.add(n);
    }
    /**
     * @param test
     */
    
    public void drawGraph(int[][] test){
        int frontier = test.length;
        int i = 0;
        int j = 0;
        for(i = 0; i < frontier; i++) V.add(new Node(i));
        for(Node n: V){
            for(j = 0; j < frontier; j++){
                if(test[V.indexOf(n)][j] != 0){
                    n.edgeLabeling(V.get(j), test[V.indexOf(n)][j]);
                }
            }
        }

    }
    
    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for(Node nodes: V){	
            sb.append("Node: " + nodes.node + "\nCost: " + nodes.cost);
            if (nodes.interior != null) sb.append("\nInterior: "+ nodes.interior.node);
            sb.append("\nAdjacency List: ");
            for (Edge e : nodes.arc) {
                sb.append("(" + e.source.node + ", " + e.destination.node + ") \nCost: "+ e.weight + "\n");
            }
            System.out.print(sb.toString());
        }
    }
    /**
     * The running time of this is O((V-1)!) ~ V^V = 2^(VlogV) because there are (V-1)! ways of paths to traverse in a graph like this.
     * Slide 16 explains this runtime although I think their equation is off by one(reasoning is sound tho):
     * https://courses.csail.mit.edu/6.006/spring11/lectures/lec14.pdf
     */
    
    public List<Dipath> naiveBruteForce(){
        List<Dipath> dipaths = new ArrayList<Dipath>();
        Dipath adjPath = null;
        List<Edge> edges = new ArrayList<Edge>();
        for(Node nodes: V){
            for(Edge e: nodes.arc){
                edges.add(e);
            }
        }
        adjPath = new Dipath();
        adjPath.edgeLabeling(edges.get(0));
        dipaths.add(adjPath);
        for(Edge e: edges){	
            List<Dipath> paths = new ArrayList<Dipath>(dipaths);			
            for(Dipath di: paths){
                adjPath = new Dipath();
                adjPath.path.addAll(di.path);
                adjPath.cost = di.cost;
                if(!adjPath.flagger(e)){
                    adjPath = new Dipath();
                    adjPath.edgeLabeling(e);
                }else adjPath.edgeLabeling(e);
                if(!dipaths.contains(adjPath)) dipaths.add(adjPath);
            }
        }
        
        List<Dipath> temp = new ArrayList<Dipath>(dipaths);
        for(Dipath di: temp){
            if(!(di.path.get(0).source.node == 0 && V.size() - 1 == di.path.get(di.path.size() - 1).destination.node)){
                dipaths.remove(di);
            }
        }
        return dipaths;
    }
    /**
     * Returns the minimum dipath for the naive approach.
     */
    
    public Dipath minimumNaiveBruteForce(){
        Dipath min = null;
        List<Dipath> completePaths = this.naiveBruteForce();
        for(Dipath path: completePaths){
            min = (min != null) ? min.cost > path.cost ? path : min  : path;
        }
        return min;
    }
    /**
     * Given an interior node and destination returns back the edge.
     * @param source interior node
     * @param desination frontior node
     */
    public Edge getEdge(Node source, Node destination){
        Edge temp = null;
        for(Node node : V){
            for(Edge edges : node.arc){
                if(edges.source.node == source.node && edges.destination.node == destination.node){
                    temp = edges;
                }
            }
        }
        return temp;
    }
    /**
     * Bredth First Search using decrease and conquer. Explores all local nodes and returns local min at each stage
     * keeping the global min as it goes along.
     * https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-design-and-analysis-of-algorithms-spring-2012/lecture-notes/MIT6_046JS12_lec06.pdf
     */
    
    public Dipath BreadthFirstSearch(){
        Node source = V.get(0);
        Node destination = V.get(V.size() - 1);
        source.cost = 0;
        BFS(source, destination);
        return recoverPath();

    }
    
    /**
     * Calculates the minimum local path in a area around the node keeping the shortest at
     * each recursive call.
     * @param source
     * @param destination 
     */
    public void BFS(Node source, Node destination){
        for(Edge edges: source.arc){
            if(source.cost + edges.weight < edges.destination.cost){
                edges.destination.cost = source.cost + edges.weight;
                if(!source.arc.isEmpty() && !edges.destination.visited){
                    BFS(edges.destination, destination);
                    edges.destination.interior = source;
                }
            }
        }		

    }
    /**
     * 
     */
    
    public Dipath Dijkstra(){
        V.get(0).cost = 0;
        for(Node node: V){
                for(Edge edges: node.arc){
                    if(!edges.destination.visited){
                        if(edges.destination.cost > (node.cost+ edges.weight)){
                            edges.destination.cost = node.cost + edges.weight;
                            edges.destination.interior = node;
                        }
                    }

                }
                node.visited = true;
        }
        return recoverPath();
    }

    /**
     * Recovers the path for both BFS and Dijkstra's algorithm
     */
    public Dipath recoverPath(){
        Dipath dipath = new Dipath();
        List<Node> vertices = new ArrayList<Node>(V);
        Collections.reverse(vertices);
        for(Node nodes: vertices){
            if(nodes.interior != null){
                Edge temp = getEdge(nodes.interior, nodes);
                if(temp != null){
                    dipath.edgeLabeling(temp);
                }
            }
        }
        return dipath;
    }

}