package com.hlx.test.recursive;

public class SelectGroup2 { // programming work 6.5
	private char[] persons; // 组中所有可供选择的成员
	private boolean[] selects; // 标记成员选中与否

	public SelectGroup2(char[] persons) {
		this.persons = persons;
		selects = new boolean[persons.length];
	}

	public void showTeams(int teamNumber) {
		showTeams(teamNumber, 0);
	}

	// =============================================
	// 找所有可能的解
	// teamNumber需要选择的队员数
	// index从第几个队员开始选择
	// =============================================
	// 从n个人中取出k个人的所可能方案
	// 此处方法参数有些变化(n,k)应写成(k,i)(i=0,1,2,...)
	// 当k=0时得一个解，i>=n时无解
	// 否则(k,i)-->(k-1,i+1)+(k,i+1)
	// =============================================
	// 列如 ：从3个人中选2个人，
	// 参数应写成(2,0)
	// (2,0)-->(1,1)+(2,1)-->(0,2)+(1,2)+(1,2)+(2,2)
	// (0,2)得一解
	// (1,2)+(1,2)+(2,2)-->(0,3)+(1,3)+(0,3)+(1,3)+(1,3)+(2,3)
	// (0,3)得一解，(1,3)无解，(2,3)无解，有两个(0,3)
	// 所以(2,0)有三个解
	// =============================================
	private void showTeams(int teamNumber, int index) {
		if (teamNumber == 0) { // 当teamNuber=0时 找到
			for (int i = 0; i < selects.length; i++) {
				if (selects[i] == true) {
					System.out.print(persons[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		if (index >= persons.length) {// index超过可供选择的人的数,未找到
			return;
		}
		selects[index] = true;
		showTeams(teamNumber - 1, index + 1);
		selects[index] = false;
		showTeams(teamNumber, index + 1);
	}

	public static void main(String[] args) {
		SelectGroup2 group = new SelectGroup2(new char[] { 'A', 'B', 'C', 'D', 'E' });
		group.showTeams(3);
	}
}
