package com.hlx.test.graph;

import com.hlx.algorithm.graph.Graph;

// programming work 13.4
public class GraphWarshallTest {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A');    // 0
		theGraph.addVertex('B');    // 1
		theGraph.addVertex('C');    // 2
		theGraph.addVertex('D');    // 3
		theGraph.addVertex('E');    // 4
		theGraph.addVertex('F');    // 5
		
		theGraph.addDirectEdge(0, 1);     // AB
		theGraph.addDirectEdge(1, 2);     // BC
		theGraph.addDirectEdge(0, 3);     // AD
		theGraph.addDirectEdge(3, 4);     // DE
		theGraph.addDirectEdge(0, 5);     // AF
		
		System.out.println("原始矩阵： ");
		theGraph.displayMat();
		theGraph.doTransitiveClosure();
		System.out.println("生成传递闭包： ");
		theGraph.displayMat();
	}
}
