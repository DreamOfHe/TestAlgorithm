package com.hlx.algorithm.linklist;

// programming work 5.6
// 具本实现可能和题目要求有些出入
public class MatrixLinkList {
	private MatrixLink first;
	private int high;
	private int width;

	public MatrixLinkList(int high, int width) {
		this.high = high;
		this.width = width;
		MatrixLink row1 = createRow(); // 生成第一行
		first = row1;
		for (int i = 2; i <= high; i++) {
			MatrixLink row = createRow();
			connectTwoRow(row1, row); // 连接两行
			row1 = row;
		}
	}
	
	// 插入或修改一个值
	public void insert(int row, int column, int value) {
		MatrixLink current = first;
		for (int i = 1; i < row; i++) {
			current = current.goDown;
		}
		for (int i = 1; i < column; i++) {
			current = current.goRight;
		}
		current.setId(value);
	}

	// 插入一行
	public void addRow(int index) {
		if (high == 0) {// 空矩阵不能添加列
			return;
		}
		if (index < 1 || index > high + 1) {// 插入的位置非法
			return;
		}
		MatrixLink newRow = createRow(); // 新行
		MatrixLink previousRow = first;
		if (index == 1) { // 插到第一行
			connectTwoRow(newRow, previousRow);
			first = newRow;
		} else if (index == high + 1) { // 插到最后一行后面
			while (previousRow.goDown != null) {
				previousRow = previousRow.goDown; // 找到最后一行
			}
			connectTwoRow(previousRow, newRow);
		} else {// �嵽�м�
			for (int i = 2; i < index; i++) {
				previousRow = previousRow.goDown;// 插入行位置的前一行
			}
			MatrixLink currentRow = previousRow.goDown; // 插入行位置
			connectTwoRow(previousRow, newRow);
			connectTwoRow(newRow, currentRow);
		}
		high++;// 行数加一
	}

	// 插入一列
	public void addColumn(int index) {
		if (width == 0) {// 空矩阵不能添加列
			return;
		}
		if (index < 1 || index > width + 1) { // 插入的位置非法
			return;
		}
		MatrixLink newColumn = createColumn();
		MatrixLink previousColumn = first;
		if (index == 1) { // 插到第一列
			connectTwoColumn(newColumn, previousColumn);
			first = newColumn;
		} else {
			for (int i = 2; i < index; i++) {
				previousColumn = previousColumn.goRight;// 插入列位置的前一列
			}
			MatrixLink currentColumn = previousColumn.goRight;// 插入列位置
			connectTwoColumn(previousColumn, newColumn);
			connectTwoColumn(newColumn, currentColumn);
		}
		width++;// 列数加一
	}

	// 生成一列
	private MatrixLink createColumn() {
		MatrixLink first = new MatrixLink();
		MatrixLink down = first;
		for (int i = 2; i <= high; i++) {
			down.goDown = new MatrixLink();
			down = down.goDown;
		}
		return first;
	}

	// 生成一行
	private MatrixLink createRow() {
		MatrixLink first = new MatrixLink();
		MatrixLink right = first;
		for (int i = 2; i <= width; i++) {
			right.goRight = new MatrixLink();
			right = right.goRight;
		}
		return first;
	}

	// 合并两行
	private void connectTwoRow(MatrixLink first1, MatrixLink first2) {// first2可以为空
		if (first2 == null) {
			while (first1 != null) {
				first1.goDown = null;
				first1 = first1.goRight;
			}
		}
		while (first1 != null) {
			first1.goDown = first2;
			first1 = first1.goRight;
			first2 = first2.goRight;
		}
	}

	// 合并两列
	private void connectTwoColumn(MatrixLink first1, MatrixLink first2) { // first2可以为空
		if (first2 == null) {
			while (first1 != null) {
				first1.goRight = null;
				first1 = first1.goDown;
			}
		}
		while (first1 != null) {
			first1.goRight = first2;
			first1 = first1.goDown;
			first2 = first2.goDown;
		}
	}

	// 删除行
	public MatrixLink deleteRow(int index) {
		if (index < 1 || index > high) { // 删除非法行
			return null;
		}
		MatrixLink previousRow = first; // 要删除行的前一行
		MatrixLink destinationRow = first; // 要删除的行
		if (index == 1) { // 删除第一行
			first = first.goDown; // first指向第二行就行了
		} else {
			for (int i = 1; i < index; i++) {
				previousRow = previousRow.goDown;// 移动到目标行的前一行
			}
			destinationRow = previousRow.goDown;// 目标行
			MatrixLink behindRow = previousRow.goDown.goDown;// 目标行后一行
			connectTwoRow(previousRow, behindRow);
		}
		high--; // 行数减少
		return destinationRow;
	}

	// 删除列
	public MatrixLink deleteColumn(int index) {
		if (index < 1 || index > width) { // 删除非法行
			return null;
		}
		MatrixLink previousColumn = first; // 要删除列的前一列
		MatrixLink destinationColumn = first; // 要删除的列
		if (index == 1) { // 删除第一列
			first = first.goRight; // first指向第二列就行了
		} else {
			for (int i = 1; i < index; i++) {
				previousColumn = previousColumn.goRight;// 移动到目标列的前一列
			}
			destinationColumn = previousColumn.goRight; // 目标列
			MatrixLink behindColumn = previousColumn.goRight.goRight; // 目标列后一列
			connectTwoColumn(previousColumn, behindColumn);
		}
		width--; // 列数减一
		return destinationColumn;
	}

	// 删除值
	public void remove(int row, int column) {
		MatrixLink current = first;
		for (int i = 1; i < row; i++) {
			current = current.goDown;
		}
		for (int i = 1; i < column; i++) {
			current = current.goRight;
		}
		current.setId(0);
	}

	// 打印显示
	public void display() {
		if (first == null) {
			System.out.println();
			return;
		}
		MatrixLink down = first;
		MatrixLink right = first;
		for (int i = 0; i < high; i++) {
			while (right != null) {
				System.out.print(right.getId());
				right = right.goRight;
			}
			System.out.println();
			down = down.goDown;
			right = down;
		}
	}
}
