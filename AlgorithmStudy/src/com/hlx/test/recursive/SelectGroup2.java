package com.hlx.test.recursive;

public class SelectGroup2 { // programming work 6.5
	private char[] persons; // �������пɹ�ѡ��ĳ�Ա
	private boolean[] selects; // ��ǳ�Աѡ�����

	public SelectGroup2(char[] persons) {
		this.persons = persons;
		selects = new boolean[persons.length];
	}

	public void showTeams(int teamNumber) {
		showTeams(teamNumber, 0);
	}

	// =============================================
	// �����п��ܵĽ�
	// teamNumber��Ҫѡ��Ķ�Ա��
	// index�ӵڼ�����Ա��ʼѡ��
	// =============================================
	// ��n������ȡ��k���˵������ܷ���
	// �˴�����������Щ�仯(n,k)Ӧд��(k,i)(i=0,1,2,...)
	// ��k=0ʱ��һ���⣬i>=nʱ�޽�
	// ����(k,i)-->(k-1,i+1)+(k,i+1)
	// =============================================
	// ���� ����3������ѡ2���ˣ�
	// ����Ӧд��(2,0)
	// (2,0)-->(1,1)+(2,1)-->(0,2)+(1,2)+(1,2)+(2,2)
	// (0,2)��һ��
	// (1,2)+(1,2)+(2,2)-->(0,3)+(1,3)+(0,3)+(1,3)+(1,3)+(2,3)
	// (0,3)��һ�⣬(1,3)�޽⣬(2,3)�޽⣬������(0,3)
	// ����(2,0)��������
	// =============================================
	private void showTeams(int teamNumber, int index) {
		if (teamNumber == 0) { // ��teamNuber=0ʱ �ҵ�
			for (int i = 0; i < selects.length; i++) {
				if (selects[i] == true) {
					System.out.print(persons[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		if (index >= persons.length) {// index�����ɹ�ѡ����˵���,δ�ҵ�
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
