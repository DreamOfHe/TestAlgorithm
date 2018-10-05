package com.hlx.algorithm.graph;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;          // list of vertices
	private int adjMat[][];               // adjacency matrix
	private int nVerts;                   // current number of vertices
	private StackG theStack;              // stack for dfs and mst
	private QueueG theQueue;              // queue for bfs
	private char sortedArray[];           // array for topo sort
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++){   // set adjacency matrix to 0
			for(int k=0; k<MAX_VERTS; k++){
				adjMat[j][k]=0;
			}
		}
		theStack = new StackG();
		theQueue = new QueueG();
		sortedArray = new char[MAX_VERTS];  // sorted vert labels
	}
	
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void addDirectEdge(int start, int end){
		adjMat[start][end] = 1;
	}
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].getLabel());
	}
	
	public void dfs(){          // depth-first search
		vertexList[0].setVisited(true);
		displayVertex(0);
		theStack.push(0);
		
		while( !theStack.isEmpty()){    // until stack empty
			// get an unvisited vertex adjacent to stack top
			int v = getAdjUnvisitedVertex(theStack.peek());
			if(v == -1){    // if no such vertex
				theStack.pop();
			} else {        // if it exist
				vertexList[v].setVisited(true);   // mark it
				displayVertex(v);
				theStack.push(v);
			}
		}
		
		// stack is empty, so we're done
		for(int j=0; j<nVerts; j++){      // reset flags
			vertexList[j].setVisited(false);
		}
	}
	
	public void bfs(){          // breadth-first search
		vertexList[0].setVisited(true);
		displayVertex(0);
		theQueue.insert(0);     // insert at tail
		int v2;
		
		while( !theQueue.isEmpty()){    // until queue empty
			int v1 = theQueue.remove();  // remove vertex at head
			// until it has no unvisited neighbors
			while((v2=getAdjUnvisitedVertex(v1)) != -1){
				vertexList[v2].setVisited(true);
				displayVertex(v2);
				theQueue.insert(v2);
			}
		}
		
		// queue is empty, so we're done
		for(int j=0; j<nVerts; j++){      // reset flags
			vertexList[j].setVisited(false);
		}
	}
	
	// minimum spanning tree (depth first)
	public void mst1(){       
		vertexList[0].setVisited(true);
		theStack.push(0);
		
		while( !theStack.isEmpty()){    // until stack empty
			// get an unvisited vertex adjacent to stack top
			int currentVertex = theStack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			if(v == -1){    // if no such vertex
				theStack.pop();
			} else {        // if it exist
				vertexList[v].setVisited(true);   // mark it
				theStack.push(v);
				
				// display edge
				displayVertex(currentVertex);     // from currentV
				displayVertex(v);                 // to V
				System.out.print(" ");
			}
		}
		
		// stack is empty, so we're done
		for(int j=0; j<nVerts; j++){      // reset flags
			vertexList[j].setVisited(false);
		}
	}
	
	// programming work 13.1
	// minimum spanning tree (breadth first)
	public void mst2(){
		vertexList[0].setVisited(true);
		theQueue.insert(0);     // insert at tail
		int v2;
		
		while( !theQueue.isEmpty()){    // until queue empty
			int v1 = theQueue.remove();  // remove vertex at head
			// until it has no unvisited neighbors
			while((v2=getAdjUnvisitedVertex(v1)) != -1){
				vertexList[v2].setVisited(true);
				displayVertex(v1);
				displayVertex(v2);
				System.out.print(" ");
				theQueue.insert(v2);
			}
		}
		
		// queue is empty, so we're done
		for(int j=0; j<nVerts; j++){      // reset flags
			vertexList[j].setVisited(false);
		}
	}
	
	public void topo(){   // topological sort
		int orig_nVerts = nVerts;  // remember how many verts
		while(nVerts > 0){   // while vertices remain
			// get a vertex with no successors, or -1
			int currentVertex = noSuccessors();
			if(currentVertex == -1){   // must be a cycyle
				System.out.println("ERROR: Graph has cycles");
				return;
			}
			// insert vertex label in sorted array (start at end)
			sortedArray[nVerts-1] = vertexList[currentVertex].getLabel();
			deleteVertex(currentVertex);  // delete vertex
		}
		
		// vertices all gone; display sortedArray
		System.out.print("Topologically sorted order: ");
		for(int j=0; j<orig_nVerts; j++){
			System.out.print(sortedArray[j]);
		}
		System.out.println("");
	}
	
	public void deleteVertex(int delVert){
		// if not last vertex
		if(delVert != nVerts-1){
			// delete from vertexList
			for(int j=delVert; j<nVerts; j++){
				vertexList[j] = vertexList[j+1];
			}
			// delete row from adjMat
			for(int row=delVert; row<nVerts-1; row++){
				moveRowUp(row, nVerts);
			}
			// delete col from adjMat
			for(int col=delVert; col<nVerts-1; col++){
				moveColLeft(col, nVerts-1);
			}
		}
		nVerts--;
	}
	
	// programming work 13.3
	// 显示有向图的连通性，通过修改 dfs() 方法得来
	public void getConnectivity(){
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].setVisited(true);  // mark it
			displayVertex(i); // display it
			theStack.push(i);                 // push it
			while (!theStack.isEmpty())      // until stack empty,
			{
				// get an unvisited vertex adjacent to stack top
				int v = getAdjUnvisitedVertex(theStack.peek());
				if (v == -1)                    // if no such vertex,
					theStack.pop();
				else                           // if it exists,
				{
					vertexList[v].setVisited(true);  // mark it
					displayVertex(v);                 // display it
					theStack.push(v);                 // push it
				}
			}  // end while
				// stack is empty, so we're done
			for (int j = 0; j < nVerts; j++)
				// reset flags
				vertexList[j].setVisited(false);
			System.out.println();
		}
	}
	
	// programming work 13.4
	// TransitiveClosure 传递闭包
	// Warshall 算法
	public void doTransitiveClosure(){
		for(int x=0; x<adjMat.length; x++){        // 行
			for(int y=0; y<adjMat.length; y++){    // 列 
				if(adjMat[x][y] == 1){             // x -> y         
					for(int z=0; z<adjMat.length; z++){   // 行
						if(adjMat[z][x] == 1){     // z -> x
							adjMat[z][y] = 1;      // z -> y
						}
					}
				}
			}
			
		}
	}
	
	public void displayMat(){
		for(int i=0; i<nVerts; i++){
			for(int j=0; j<nVerts; j++){
				System.out.print(adjMat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// returns vert with no successors (or -1 if no such verts)
	private int noSuccessors(){
		boolean isEdge;    // edge from row to column in adjMat
		
		for(int row=0; row<nVerts; row++){       // for each vertex
			isEdge = false;                      // check edges
			for(int col=0; col<nVerts; col++){   
				if(adjMat[row][col] > 0){ // if edge to another
					isEdge = true;
					break; // this vertex has a successor, try another
				}
			}
			if(!isEdge){   // if no edges, has no successors
				return row;
			}
		}
		return -1;         // no such vertex
	}

	private void moveRowUp(int row, int length){
		for(int col=0; col<length; col++){
			adjMat[row][col] = adjMat[row+1][col];
		}
	}
	
	private void moveColLeft(int col, int length){
		for(int row=0; row<length; row++){
			adjMat[row][col] = adjMat[row][col+1];
		}
	}
	
	// returns an unvisited vertex adj to v
	private int getAdjUnvisitedVertex(int v){
		for(int j=0; j<nVerts; j++){
			if(adjMat[v][j] == 1 && vertexList[j].isVisited() == false){
				return j;
			}
		}
		return -1;
	}
}
