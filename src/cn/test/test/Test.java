package cn.test.test;

/**
 * ����
 * 
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		String[] s1 = { "����", "���", "����", "��С��", "١��", "Ϧ��", "����", "���ӷ�", "���޳�", "���޳�", "����", "���" };
		// ɾ�� ������ɾ�� ɾ��˭ ������ʼ Ҫɾ����
		removeElement(s1, 1, 8);
	}

	static String[] addElement(String[] s1) {
		String[] s2 = new String[s1.length * 2];
		System.arraycopy(s1, 0, s2, 0, s1.length);
		for (int i = 0; i < s2.length; i++) {
			System.out.println(i + "\t" + s2[i]);
		}
		return s2;
	}

	static String[] addElement1(String[] s1) {
		String[] s2 = new String[10];
		s2[0] = "wsc";
		s2[1] = "yjk";
		s2[2] = "lcl";
		s2[2 + s1.length] = s2[2];
		System.arraycopy(s1, 0, s2, 2, 3);
		for (int i = 0; i < s2.length; i++) {
			System.out.println(i + "\t" + s2[i]);
		}

		return s2;
	}

	static String[] removeElement(String[] s1, int index, int num) {
		index += num;
		System.arraycopy(s1, index, s1, index - num, s1.length - index);

		for (int i = 0; i < s1.length; i++) {
			System.out.println(i + "\t" + s1[i]);
//			for(int j =s1.length-index+1;j<s1.length;j++) {
//				s1[j]=null;
//			}
			for (int j = s1.length - 1; j > s1.length - index; j--) {
				s1[j] = null;
			}
		}
		return s1;
	}
}
