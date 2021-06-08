package com.gs.ds.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdjacentSetGraphTest {

    @Test
    public void create_undirected_graph() {
        AdjacentSetGraph adjacentSetGraph = new AdjacentSetGraph(5, Graph.GraphType.UNDIRECTED);
        adjacentSetGraph.addEdges(2, 3);

        assert (adjacentSetGraph.getAdjacentVertices(2).size() == 1);
        assert (adjacentSetGraph.getAdjacentVertices(2).get(0) == 3);
        assert (adjacentSetGraph.getAdjacentVertices(3).size() == 1);
        assert (adjacentSetGraph.getAdjacentVertices(3).get(0) == 2);
    }

    @Test
    public void create_directed_graph() {
        AdjacentSetGraph adjacentSetGraph = new AdjacentSetGraph(5, Graph.GraphType.DIRECTED);
        adjacentSetGraph.addEdges(1, 2);

        assert (adjacentSetGraph.getAdjacentVertices(1).size() == 1);
        assert (adjacentSetGraph.getAdjacentVertices(1).get(0) == 2);
        assert (adjacentSetGraph.getAdjacentVertices(2).size() == 0);
    }

    @Test
    public void check_for_adjacent_vertices_for_invalid_vertex() {
        AdjacentSetGraph adjacentSetGraph = new AdjacentSetGraph(5, Graph.GraphType.DIRECTED);
        assertThrows(IllegalArgumentException.class, () -> {
            adjacentSetGraph.addEdges(2, 3);
            adjacentSetGraph.getAdjacentVertices(7);
        });
    }

    @Test
    public void add_adjacent_vertices_for_invalid_vertex() {
        AdjacentSetGraph adjacentSetGraph = new AdjacentSetGraph(5, Graph.GraphType.DIRECTED);
        assertThrows(IllegalArgumentException.class, () -> adjacentSetGraph.addEdges(2, 2));
    }
}
