package com.hlx.test.recursive;

public class SelectGroup1 { // programming work 6.5
	private char[] persons; // �������пɹ�ѡ��ĳ�Ա
	private boolean[] selects; // ��ǳ�Աѡ�����

	public SelectGroup1(char[] persons) {
		this.persons = persons;
		selects = new boolean[persons.length];
	}

	public void showTeams(int teamNumber) {
		showTeams(persons.length, teamNumber);
	}

	// =============================================
	// �����п��ܵĽ�
	// totalNuber �ܹ��ж����˹�ѡ��
	// teamNuber ��Ҫѡ�������
	// =============================================
	// �Ӹ�n����ȡ��k���˵������ܷ�������ʾΪ��������(n,k)
	// ��(n,k)�����н�
	// ��k=0ʱ��һ���⣬n<kʱ�޽�
	// ����(n,k)-->(n-1,k-1)+(n-1,k)
	// =============================================
	// ���� ����3������ѡ2���ˣ���ʱ����Ϊ(3,2)
	// (3,2)-->(2,1)+(2,2)-->(1,0)+(1,1)+(1,1)+(1,2)
	// (1,0)�õ�һ����,(1,2)�޽�
	// (1,0)+(1,1)+(1,1)+(1,2)-->(1,1)+(1,1)
	// (1,1)+(1,1)-->(0,0)+(0,1)+(0,0)+(0,1)
	// (0,0)�õ�һ����,(0,1)�޽�
	// ����(3,2)һ���� 3����
	// ���� ����3������ѡ3���ˣ���ʱ����Ϊ(3,3)
	// (3,3)-->(2,2)+(2,3)-->(2,2)-->(1,1)+(1,2)-->(1,1)-->(0,0)+(0,1)-->(0,0)
	// ��(3,3)��һ����
	// =============================================
	private void showTeams(int totalNumber, int teamNumber) {
		if (teamNumber == 0) { // teamNumber=0ʱ, �ҵ�һ����
			for (int i = 0; i < selects.length; i++) {
				if (selects[i] == true) {
					System.out.print(persons[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		if (totalNumber < teamNumber) { // totalNuber< teamNumber,�޽�
			return;
		}
		selects[persons.length - totalNumber] = true;
		showTeams(totalNumber - 1, teamNumber - 1);
		selects[persons.length - totalNumber] = false;
		showTeams(totalNumber - 1, teamNumber);
	}

	public static void main(String[] args) {
		SelectGroup1 group = new SelectGroup1(new char[] { 'A', 'B', 'C', 'D', 'E' });
		group.showTeams(3);
	}
}
