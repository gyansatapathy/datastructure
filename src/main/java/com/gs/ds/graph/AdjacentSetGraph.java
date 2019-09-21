package com.gs.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacentSetGraph implements Graph {

    private List<GraphNode> graphNodes = null;
    private GraphType graphType;
    private int noOfVertices;

    public AdjacentSetGraph(int noOfVertices,GraphType graphType) {
        this.graphType = graphType;
        this.noOfVertices = noOfVertices;

        graphNodes = new ArrayList<GraphNode>(noOfVertices);

        for(int i = 0; i < noOfVertices; i++){
            graphNodes.add(i, new GraphNode(i));
        }
    }

    public void addEdges(int a, int b) throws IllegalArgumentException {
        if (a < 0 || a > noOfVertices || b < 0 || b > noOfVertices || a == b) {
            throw new IllegalArgumentException("Not a valid vertex");
        }
        graphNodes.get(a).addAdjacentVertex(b);

        if (graphType == GraphType.UNDIRECTED) {
            graphNodes.get(b).addAdjacentVertex(a);
        }
    }

    public List<Integer> getAdjacentVertices(int v) throws IllegalArgumentException {
        if(v < 0 || v > noOfVertices){
            throw new IllegalArgumentException("Not a valid vertex given");
        }
        return graphNodes.get(v).getAdjacentVertixes();
    }

    public int getNoOfVertices() {
        return noOfVertices;
    }
}
