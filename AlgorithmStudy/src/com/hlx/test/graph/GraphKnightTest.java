package com.hlx.test.graph;

import java.io.IOException;

import com.hlx.common.MyMethod;


/*
	13.5 骑士旅行是一个古老而著名的象棋谜题。题目是在一个空的棋盘上移动一个
	 骑士，从一个方块到另一个，直到踏遍了棋盘的所有的方块。写一个程序，
	 用深度优先搜索解决这个问题。最好使棋盘的大小可变，这样可以在较小的
	 棋盘上解决这个问题。8*8的棋盘中，用个人电脑大概需要几年的时间解决
	 这个问题。5*5的棋盘只需要几分钟而已。
	 //骑士只能根据象棋的规则进行移动，要么横向跳动一格纵向跳动两格
	 //要么纵向跳动一格横向跳动两格。   例如，   n=4，m=3   时，若骑士在格子(2;1)，   
	 //则骑士只能移入下面格子：(1;3),(3;3) 或   (4;2)
*/
//=================================================================
class StackG {
	private final int SIZE = 200;
	private Lattice[] st;
	private int top;

	// ------------------------------------------------------------
	public StackG()           // constructor
	{
		st = new Lattice[SIZE];    // make array
		top = -1;
	}

	// ------------------------------------------------------------
	public void push(Lattice j)   // put item on stack
	{
		st[++top] = j;
	}

	// ------------------------------------------------------------
	public Lattice pop()          // take item off stack
	{
		return st[top--];
	}

	// ------------------------------------------------------------
	public Lattice peek()         // peek at top of stack
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

//=================================================================
//lattice 格子
//棋格
class Lattice {
	public int f; // 从前驱棋格的哪个方向而来
	public int x;
	public int y;

	public Lattice(int f, int x, int y) {
		this.f = f;
		this.x = x;
		this.y = y;
	}

	public Lattice getNextLattice(int f, Direction d) {
		return new Lattice(f, this.x + d.x, this.y + d.y);
	}
}

//=================================================================
//移动的方向
class Direction {
	public int x;
	public int y;

	public Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

//=================================================================
class Chess {

	// =================================================================
	// 参数
	private boolean[][] chessBoard; // 棋盘
	int MAX_X = 5; // 棋盘宽
	int MAX_Y = 5; // 棋盘高
	private int number; // 未访问棋格数
	private Lattice[] path;

	private Direction[] direction; // 移动方向
	{
		direction = new Direction[] { new Direction(2, -1),
				new Direction(2, 1), new Direction(1, 2), new Direction(-1, 2),
				new Direction(-2, 1), new Direction(-2, -1),
				new Direction(-1, -2), new Direction(1, -2) };
	}

	// =================================================================
	public Chess(int x, int y) {
		this.MAX_X = x;
		this.MAX_Y = y;
		this.number = MAX_X * MAX_Y; // 未访问棋格数
		this.chessBoard = new boolean[MAX_X][MAX_Y]; // 棋盘
		for (int i = 0; i < MAX_X; i++) { // 初始化棋盘
			for (int j = 0; j < MAX_Y; j++) {
				chessBoard[i][j] = false;
			}
		}
		path = new Lattice[number];
	}

	// =================================================================
	// 判断给定棋格lattice，是否在棋盘内，超出范围则不合法
	public boolean isValid(Lattice lattice) {
		if (lattice.x >= 0 && lattice.y >= 0 && lattice.x < MAX_X
				&& lattice.y < MAX_Y) {
			return true;
		}
		return false;
	}

	// =================================================================
	// lattice 给定的棋格
	// f 开始遍历的方法
	// 返回lattice的下一个未访问的后继棋格
	public Lattice getNextUnVisitedLattice(int f, Lattice lattice) {
		for (int i = f; i < direction.length; i++) {
			Lattice temp = lattice.getNextLattice(i, direction[i]);
			if (isValid(temp)) { // 在棋盘内
				if (!chessBoard[temp.x][temp.y]) { // 没有访问
					return temp;
				}
			}
		}
		return null;
	}

	// =================================================================
	// 编程作业 13.5
	// 骑士的旅行
	// 过程：
	// 首先任选一个棋格标记为已访问并加入栈
	// 如果栈不为空-------(1)
	// --找栈顶棋格的后继未访问棋格
	// --如果找到，则后继未访问棋格标记为已访问，并入栈
	// --如果未找到，则把栈顶元素退栈
	// --如果所有棋格都已入栈，则骑士旅行完成，方法结束
	// 循环进入(1)
	// 如果栈为空
	// 则未找到骑士旅行的路径，方法结束
	public void knightTour() {
		StackG path = new StackG(); // 存放已访问的棋格
		path.push(new Lattice(-1, 0, 0)); // 从第(0,0)个棋格开始
		number--;
		chessBoard[0][0] = true;
		// disPlayChessBoard();
		int f = 0; // 方向

		while (!path.isEmpty()) {
			Lattice temp = getNextUnVisitedLattice(f, path.peek()); // 后继未访问棋格
			if (temp == null) { // 没找到
				Lattice l = path.pop();
				chessBoard[l.x][l.y] = false;
				f = l.f + 1; // 下一个方向
				number++;
			} else {// 找到
				chessBoard[temp.x][temp.y] = true;
				path.push(temp);
				f = 0; // 下一个方向
				number--;
			}

			// 如果number == 0,说明，全部棋格已入栈，则骑士旅行完成
			if (number == 0) {
				int j = this.path.length - 1;
				while (!path.isEmpty()) { // 把栈中棋格转存入数组
					this.path[j--] = path.pop();

				}
				disPlayKnightTour(); // 显示骑士旅行路径
				System.out.println("success!找到骑士旅行的路径!");
				return;
			}
		}
		System.out.println("failure!找不到骑士旅行的路径!");
	}

	// =================================================================
	// 显示骑士旅行路径
	public void disPlayKnightTour() {
		for (int i = 0; i < MAX_X; i++) { // 初始化棋盘
			for (int k = 0; k < MAX_Y; k++) {
				chessBoard[i][k] = false;
			}
		}
		for (int i = 0; i < path.length; i++) { // 骑士每移动一步，打印一次棋盘
			Lattice temp = path[i];
			chessBoard[temp.x][temp.y] = true;
			disPlayChessBoard();
		}
	}

	// =================================================================
	// 打印棋盘
	public void disPlayChessBoard() {
		System.out.print("  ");
		for (int i = 0; i < MAX_Y; i++) {
			System.out.print(" " + i);
		}
		System.out.println();
		for (int i = 0; i < MAX_X; i++) {
			System.out.print(" " + i);
			for (int j = 0; j < MAX_Y; j++) {
				if (chessBoard[i][j] == false) {
					System.out.print(" □");
				} else {
					System.out.print(" ■");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	// =================================================================

}

public class GraphKnightTest {
	public static void main(String[] args) throws IOException {
		System.out.print("请输入棋盘的宽：");
		int x = MyMethod.getInt();
		System.out.print("请输入棋盘的高：");
		int y = MyMethod.getInt();
		Chess chess = new Chess(x, y);
		//chess.disPlayChessBoard();
		chess.knightTour();
	}
}