package com.hlx.test.graph;

//programming work 13.2

class Vertex {
	public char label;        // label (e.g. 'A')
	public boolean wasVisited;

	// -------------------------------------------------------------
	public Vertex(char lab)   // constructor
	{
		label = lab;
		wasVisited = false;
	}
	// -------------------------------------------------------------
}  // end class Vertex
// //////////////////////////////////////////////////////////////

class Link {
	public Vertex vertex;              // data item (key)
	public Link next;              // next link in list

	// -------------------------------------------------------------

	public Link(Vertex data) // constructor
	{
		this.vertex = data;
	}

	// -------------------------------------------------------------
	public void displayLink()      // display ourself
	{
		System.out.print(vertex.label);
	}
}  // end class Link
// //////////////////////////////////////////////////////////////

class LinkList {
	public Link first;            // ref to first link on list
	public Link last;

	// -------------------------------------------------------------
	public LinkList(Vertex c)              // constructor
	{
		Link newLink = new Link(c);
		last = first = newLink;               // no links on list yet
	}

	// -------------------------------------------------------------

	public void insertFirst(Vertex c) {                 // make new link
		Link newLink = new Link(c);
		newLink.next = first;       // it points to old first link
		first = newLink;            // now first points to this
	}

	// ==============================================================
	// 编程作业 13.2
	public void insertLast(Vertex c) {                 // make new link
		Link newLink = new Link(c);
		last.next = newLink;            // now first points to this
		last = newLink;
	}

	// ==============================================================
	// 编程作业 13.2
	public Link find()      // find link with non-visited vertex
	{                           // (assumes non-empty list)
		Link current = first.next;              // start at 'first.next'
		while (current != null && current.vertex.wasVisited)  // while no match,
		{
			current = current.next;      // go to next link
		}
		return current;                    // found it
	}

	// ==============================================================
	// -------------------------------------------------------------
	public void displayList()      // display the list
	{
		Link current = first;       // start at beginning of list
		System.out.print("List (" + current.vertex.label + "): ");
		current = current.next;
		while (current != null)      // until end of list,
		{
			current.displayLink();   // print data
			current = current.next;  // move to next link
		}
		System.out.println("");
	}
	// -------------------------------------------------------------
}  // end class LinkList
// //////////////////////////////////////////////////////////////
// //////////////////////////////////////////////////////////////

class StackX {
	private final int SIZE = 20;
	private Vertex[] st;
	private int top;

	// ------------------------------------------------------------
	public StackX()           // constructor
	{
		st = new Vertex[SIZE];    // make array
		top = -1;
	}

	// ------------------------------------------------------------
	public void push(Vertex j)   // put item on stack
	{
		st[++top] = j;
	}

	// ------------------------------------------------------------
	public Vertex pop()          // take item off stack
	{
		return st[top--];
	}

	// ------------------------------------------------------------
	public Vertex peek()         // peek at top of stack
	{
		return st[top];
	}

	// ------------------------------------------------------------
	public boolean isEmpty()  // true if nothing on stack
	{
		return (top == -1);
	}
	// ------------------------------------------------------------
}  // end class StackX
// //////////////////////////////////////////////////////////////

class Graph1 {
	// ============================================================
	// 编程作业 13.2
	// 这里只用了一个LinkList数组
	// 每个LinkList的第一个节点Link表示当前节点
	// 后面节点表示与前节点相邻接的节点
	// 其实Link完全可以由Vertex代替，在Vertex里面添加一个域next
	// 这个next指向与此Vertex相邻接的顶点
	private final int MAX_VERTS = 20;
	private LinkList adjList[];      // adjacency list
	private int nVerts;          // current number of vertices
	private StackX theStack;

	// ------------------------------------------------------------
	public Graph1()               // constructor
	{
		// adjacency matrix
		adjList = new LinkList[MAX_VERTS];
		nVerts = 0;
		theStack = new StackX();
	}  // end constructor

	// ------------------------------------------------------------
	public void addVertex(char lab) {
		Vertex newVertex = new Vertex(lab);
		LinkList list = new LinkList(newVertex);
		adjList[nVerts++] = list;
	}

	// ------------------------------------------------------------
	public void addEdge(int start, int end) {
		adjList[start].insertLast(adjList[end].first.vertex);
	}

	// ------------------------------------------------------------
	public void displayVertex(Vertex v) {
		System.out.print(v.label);
	}

	// ------------------------------------------------------------
	// ============================================================
	// 编程作业 13.2
	public void dfs()  // depth-first search
	{                                 // begin at vertex 0
		adjList[0].first.vertex.wasVisited = true;  			// mark it
		displayVertex(adjList[0].first.vertex);                 // display it
		theStack.push(adjList[0].first.vertex);                 // push it

		while (!theStack.isEmpty())      // until stack empty,
		{
			// get an unvisited vertex adjacent to stack top
			Vertex v = getAdjUnvisitedVertex(theStack.peek());
			if (v == null)                    // if no such vertex,
				theStack.pop();
			else                           // if it exists,
			{
				v.wasVisited = true;  // mark it
				displayVertex(v);                 // display it
				theStack.push(v);                 // push it
			}
		}  // end while

		// stack is empty, so we're done
		for (int j = 0; j < nVerts; j++)
			// reset flags
			adjList[j].first.vertex.wasVisited = false;
	}  // end dfs

	// ============================================================
	// 编程作业 13.2
	// returns an unvisited vertex adj to v
	public Vertex getAdjUnvisitedVertex(Vertex v) {
		int j = -1;
		for (int i = 0; i < adjList.length; i++) {
			if (adjList[i].first.vertex.label == v.label) {
				j = i;
				break;
			}
		}
		Link link = adjList[j].find();
		if (link != null) {
			return adjList[j].find().vertex;
		} else {
			return null;
		}
	}  // end getAdjUnvisitedVertex()

	// ============================================================
}  // end class Graph
// //////////////////////////////////////////////////////////////

public class GraphAdjacencyTableTest {
	public static void main(String[] args) {
		Graph1 theGraph = new Graph1();
		theGraph.addVertex('A');    // 0 (start for dfs)
		theGraph.addVertex('B');    // 1
		theGraph.addVertex('C');    // 2
		theGraph.addVertex('D');    // 3
		theGraph.addVertex('E');    // 4
		theGraph.addVertex('F');    // 5

		theGraph.addEdge(0, 1);     // AB
		theGraph.addEdge(1, 2);     // BC
		theGraph.addEdge(0, 3);     // AD
		theGraph.addEdge(3, 4);     // DE
		theGraph.addEdge(0, 5);     // AF

		System.out.print("Visits: ");
		theGraph.dfs();             // depth-first search
		System.out.println();
	}  // end main()
}  // end class DFSApp

