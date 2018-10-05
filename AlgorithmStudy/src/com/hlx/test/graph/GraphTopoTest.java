package com.hlx.test.graph;

import com.hlx.algorithm.graph.Graph;

public class GraphTopoTest {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A');    // 0
		theGraph.addVertex('B');    // 1
		theGraph.addVertex('C');    // 2
		theGraph.addVertex('D');    // 3
		theGraph.addVertex('E');    // 4
		theGraph.addVertex('F');    // 5
		theGraph.addVertex('G');    // 6
		theGraph.addVertex('H');    // 7
		
		/*
		theGraph.addDirectEdge(0, 3);  // AD
		theGraph.addDirectEdge(0, 4);  // AE
		theGraph.addDirectEdge(1, 4);  // BE
		theGraph.addDirectEdge(2, 5);  // CF
		theGraph.addDirectEdge(3, 6);  // DG
		theGraph.addDirectEdge(4, 6);  // EG
		theGraph.addDirectEdge(5, 7);  // FH
		theGraph.addDirectEdge(6, 7);  // GH
		*/
		theGraph.addDirectEdge(0, 1);  // AB
		theGraph.addDirectEdge(1, 2);  // BC
		theGraph.addDirectEdge(2, 0);  // CA
		
		
		theGraph.topo();   // do the sort
	}
}
