package com.gs.ds.graph;

import org.junit.Test;

import java.util.List;

public class AdjacencyMatrixGraphTest {

    @Test
    public void create_a_directed_adjacency_matrix_graph() {
        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        assert (adjacencyMatrixGraph.getGraphType() == Graph.GraphType.DIRECTED);
        assert (adjacencyMatrixGraph.getNoOfVertices() == 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void check_for_adding_invalid_vertex_number() {
        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        adjacencyMatrixGraph.addEdges(1, 7);
    }

    @Test
    public void add_adjacent_vertex_to_a_directed_graph() {
        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        adjacencyMatrixGraph.addEdges(2, 3);
        assert (adjacencyMatrixGraph.getAdjacentVertices(2).size() == 1);
        assert (adjacencyMatrixGraph.getAdjacentVertices(2).get(0) == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void check_for_adjacent_vertixes_for_invalid_vertex_number() {
        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        adjacencyMatrixGraph.addEdges(1, 3);
        List<Integer> adjacentVertixes = adjacencyMatrixGraph.getAdjacentVertices(8);
    }

    @Test
    public void add_adjacent_vertex_to_an_undirected_graph() {
        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(5, Graph.GraphType.UNDIRECTED);
        adjacencyMatrixGraph.addEdges(2, 3);
        assert (adjacencyMatrixGraph.getAdjacentVertices(2).size() == 1);
        assert (adjacencyMatrixGraph.getAdjacentVertices(3).size() == 1);
        assert (adjacencyMatrixGraph.getAdjacentVertices(2).get(0) == 3);
        assert (adjacencyMatrixGraph.getAdjacentVertices(3).get(0) == 2);
    }
}
