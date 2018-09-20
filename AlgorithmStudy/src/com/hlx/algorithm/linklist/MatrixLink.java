package com.hlx.algorithm.linklist;

public class MatrixLink {
	public int id;
	public MatrixLink goRight;
	public MatrixLink goDown;

	public MatrixLink(int d) {
		id = d;
		goRight = null;
		goDown = null;
	}

	public MatrixLink() {
		id = 0;
		goRight = null;
		goDown = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
