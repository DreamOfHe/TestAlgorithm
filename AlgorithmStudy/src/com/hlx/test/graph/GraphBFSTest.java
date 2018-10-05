package com.hlx.test.graph;

import com.hlx.algorithm.graph.Graph;

public class GraphBFSTest {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A');    // 0
		theGraph.addVertex('B');    // 1
		theGraph.addVertex('C');    // 2
		theGraph.addVertex('D');    // 3
		theGraph.addVertex('E');    // 4
		
		theGraph.addEdge(0, 1);     // AB
		theGraph.addEdge(1, 2);     // BC
		theGraph.addEdge(0, 3);     // AD
		theGraph.addEdge(3, 4);     // DE
		theGraph.addEdge(2, 4);     // CE
		
		System.out.print("Visit: ");
		theGraph.bfs();
		System.out.println();
	}
}
