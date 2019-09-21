package com.gs.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphNode {
    private int vertexNumber;
    private Set<Integer> adjacentVertices = new HashSet<Integer>();

    public GraphNode(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public void addAdjacentVertex(int v){
        adjacentVertices.add(v);
    }

    public List<Integer> getAdjacentVertixes(){
        List<Integer> sortedAdjacentVertices = new ArrayList<Integer>(adjacentVertices);
        Collections.sort(sortedAdjacentVertices);

        return sortedAdjacentVertices;
    }
}
