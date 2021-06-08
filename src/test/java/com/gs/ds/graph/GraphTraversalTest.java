package com.gs.ds.graph;


import org.junit.jupiter.api.Test;

public class GraphTraversalTest {

    @Test
    public void test_depth_first_traversal(){
        GraphTraverse.traverseByDepth(buildUnidirectedGraph());
    }
    @Test
    public void test_breadth_first_traversal(){
        GraphTraverse.traverseByBreadth(buildUnidirectedGraph());
    }

    private Graph buildUnidirectedGraph(){
        Graph undirectedGraph = new AdjacentSetGraph(5, Graph.GraphType.UNDIRECTED);
        undirectedGraph.addEdges(0,1);
        undirectedGraph.addEdges(0,2);
        undirectedGraph.addEdges(1,3);
        undirectedGraph.addEdges(1,4);
        undirectedGraph.addEdges(3,2);
        undirectedGraph.addEdges(3,4);

        return undirectedGraph;
    }
}
