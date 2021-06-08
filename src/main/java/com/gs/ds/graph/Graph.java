package com.gs.ds.graph;

import java.util.List;

public interface Graph {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    void addEdges(int a, int b) throws IllegalArgumentException;
    List<Integer> getAdjacentVertices(int v) throws IllegalArgumentException;
    int getNoOfVertices();
}
