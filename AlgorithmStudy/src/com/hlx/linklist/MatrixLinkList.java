package com.hlx.linklist;

// programming work 5.6
// �߱�ʵ�ֿ��ܺ���ĿҪ����Щ����
public class MatrixLinkList {
	private MatrixLink first;
	private int high;
	private int width;

	public MatrixLinkList(int high, int width) {
		this.high = high;
		this.width = width;
		MatrixLink row1 = createRow(); // ���ɵ�һ��
		first = row1;
		for (int i = 2; i <= high; i++) {
			MatrixLink row = createRow();
			connectTwoRow(row1, row); // ��������
			row1 = row;
		}
	}

	// ������޸�һ��ֵ
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

	// ����һ��
	public void addRow(int index) {
		if (high == 0) {// �վ����������
			return;
		}
		if (index < 1 || index > high + 1) {// �����λ�÷Ƿ�
			return;
		}
		MatrixLink newRow = createRow(); // ����
		MatrixLink previousRow = first;
		if (index == 1) { // �嵽��һ��
			connectTwoRow(newRow, previousRow);
			first = newRow;
		} else if (index == high + 1) { // �嵽���һ�к���
			while (previousRow.goDown != null) {
				previousRow = previousRow.goDown; // �ҵ����һ��
			}
			connectTwoRow(previousRow, newRow);
		} else {// �嵽�м�
			for (int i = 2; i < index; i++) {
				previousRow = previousRow.goDown;// ������λ�õ�ǰһ��
			}
			MatrixLink currentRow = previousRow.goDown; // ������λ��
			connectTwoRow(previousRow, newRow);
			connectTwoRow(newRow, currentRow);
		}
		high++;// ������һ
	}

	// ����һ��
	public void addColumn(int index) {
		if (width == 0) {// �վ����������
			return;
		}
		if (index < 1 || index > width + 1) { // �����λ�÷Ƿ�
			return;
		}
		MatrixLink newColumn = createColumn();
		MatrixLink previousColumn = first;
		if (index == 1) { // �嵽��һ��
			connectTwoColumn(newColumn, previousColumn);
			first = newColumn;
		} else {
			for (int i = 2; i < index; i++) {
				previousColumn = previousColumn.goRight;// ������λ�õ�ǰһ��
			}
			MatrixLink currentColumn = previousColumn.goRight;// ������λ��
			connectTwoColumn(previousColumn, newColumn);
			connectTwoColumn(newColumn, currentColumn);
		}
		width++;// ������һ
	}

	// ����һ��
	private MatrixLink createColumn() {
		MatrixLink first = new MatrixLink();
		MatrixLink down = first;
		for (int i = 2; i <= high; i++) {
			down.goDown = new MatrixLink();
			down = down.goDown;
		}
		return first;
	}

	// ����һ��
	private MatrixLink createRow() {
		MatrixLink first = new MatrixLink();
		MatrixLink right = first;
		for (int i = 2; i <= width; i++) {
			right.goRight = new MatrixLink();
			right = right.goRight;
		}
		return first;
	}

	// �ϲ�����
	private void connectTwoRow(MatrixLink first1, MatrixLink first2) {// first2����Ϊ��
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

	// �ϲ�����
	private void connectTwoColumn(MatrixLink first1, MatrixLink first2) { // first2����Ϊ��
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

	// ɾ����
	public MatrixLink deleteRow(int index) {
		if (index < 1 || index > high) { // ɾ���Ƿ���
			return null;
		}
		MatrixLink previousRow = first; // Ҫɾ���е�ǰһ��
		MatrixLink destinationRow = first; // Ҫɾ������
		if (index == 1) { // ɾ����һ��
			first = first.goDown; // firstָ��ڶ��о�����
		} else {
			for (int i = 1; i < index; i++) {
				previousRow = previousRow.goDown;// �ƶ���Ŀ���е�ǰһ��
			}
			destinationRow = previousRow.goDown;// Ŀ����
			MatrixLink behindRow = previousRow.goDown.goDown;// Ŀ���к�һ��
			connectTwoRow(previousRow, behindRow);
		}
		high--; // ��������
		return destinationRow;
	}

	// ɾ����
	public MatrixLink deleteColumn(int index) {
		if (index < 1 || index > width) { // ɾ���Ƿ���
			return null;
		}
		MatrixLink previousColumn = first; // Ҫɾ���е�ǰһ��
		MatrixLink destinationColumn = first; // Ҫɾ������
		if (index == 1) { // ɾ����һ��
			first = first.goRight; // firstָ��ڶ��о�����
		} else {
			for (int i = 1; i < index; i++) {
				previousColumn = previousColumn.goRight;// �ƶ���Ŀ���е�ǰһ��
			}
			destinationColumn = previousColumn.goRight; // Ŀ����
			MatrixLink behindColumn = previousColumn.goRight.goRight; // Ŀ���к�һ��
			connectTwoColumn(previousColumn, behindColumn);
		}
		width--; // ������һ
		return destinationColumn;
	}

	// ɾ��ֵ
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

	// ��ӡ��ʾ
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
