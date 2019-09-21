package com.gs.ds.graph;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**\
 *
 * G808286
 *
 */

public class GraphTraverse {
    private static boolean[] nodeVisitedList;

    public static void traverseByDepth(@org.jetbrains.annotations.NotNull Graph graph){
        nodeVisitedList = new boolean[graph.getNoOfVertices()];

        depthFirstTraverse(nodeVisitedList,0,graph);

        //for disjoint graphs
        for(int i =0; i<graph.getNoOfVertices(); i++){
            depthFirstTraverse(nodeVisitedList,i,graph);
        }
        System.out.println();
    }

    private static void depthFirstTraverse(@NotNull boolean[] nodeVisitedList,int vertex, Graph graph){

        if(nodeVisitedList[vertex]){
            return;
        }

        nodeVisitedList[vertex] = true;

        List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);

        for(Integer nextVertex: adjacentVertices){
            depthFirstTraverse(nodeVisitedList,nextVertex,graph);
        }

        System.out.print(vertex+"--->");

    }

    public static void traverseByBreadth(@NotNull Graph graph){

        nodeVisitedList = new boolean[graph.getNoOfVertices()];
        breadthFirstTraversal(nodeVisitedList, 0, graph);
        //for disjoint graphs
        for(int i =0; i<graph.getNoOfVertices(); i++){
            breadthFirstTraversal(nodeVisitedList,i,graph);
        }
        System.out.println();


    }

    private static void breadthFirstTraversal(boolean[] nodeVisitedList, int vertex, Graph graph){
        Queue<Integer> adjacentVerticesQueue = new LinkedList<Integer>();
        adjacentVerticesQueue.add(vertex);

        while(!adjacentVerticesQueue.isEmpty()){
            Integer nextVertex = adjacentVerticesQueue.remove();
            if(nodeVisitedList[nextVertex]){
                continue;
            }
            System.out.print(nextVertex+"--->");
            nodeVisitedList[nextVertex] = true;

            List<Integer> adjacentVertices = graph.getAdjacentVertices(nextVertex);
            for (Integer adjacentVertex: adjacentVertices){
                if(nodeVisitedList[adjacentVertex]){
                    adjacentVerticesQueue.add(adjacentVertex);
                }
            }
        }
    }

}
