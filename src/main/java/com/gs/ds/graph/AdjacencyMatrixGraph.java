package com.gs.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {
    private int noOfVertices;
    private GraphType graphType;
    private int[][] adjacencyMatrix;

    public AdjacencyMatrixGraph(int noOfVertices, GraphType graphType) {
        this.noOfVertices = noOfVertices;
        this.graphType = graphType;

        adjacencyMatrix = new int[noOfVertices][noOfVertices];
    }

    public void addEdges(int a, int b) throws IllegalArgumentException{
        if(a < 0 || a > noOfVertices || b < 0 || b > noOfVertices || a == b) {
            throw new IllegalArgumentException("Invalid vertex attempted");
        }

        adjacencyMatrix[a][b] = 1;
        if(graphType == GraphType.UNDIRECTED){
            adjacencyMatrix[b][a] = 1;
        }
    }

    public List<Integer> getAdjacentVertices(int v) throws IllegalArgumentException {
        if(v < 0 || v > noOfVertices){
            throw new IllegalArgumentException("Invalid vertex");
        }

        List<Integer> adjacentVertices = new ArrayList<Integer>();

        for(int i = 0; i < noOfVertices; i++){

            if(adjacencyMatrix[v][i] == 1) {
                adjacentVertices.add(i);
            }
        }

        Collections.sort(adjacentVertices);

        return adjacentVertices;

    }

    public int getNoOfVertices() {
        return noOfVertices;
    }

    public GraphType getGraphType() {
        return graphType;
    }
}
