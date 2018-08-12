public class Edge {
    int weight;
    Node source;
    Node destination;
    public Edge(Node source, Node destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "("+this.source+", "+this.destination+")";
    }
}