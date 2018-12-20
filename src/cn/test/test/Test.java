package cn.test.test;

public class Test {
	public static void main(String[] args) {
		String[] s1 = { "À’À’", "∫Ï∫Ï", "»ÿ»ÿ" };
		addElement1(s1);
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
		s2[2+s1.length]=s2[2];
		System.arraycopy(s1, 0, s2, 2, 3);
		for (int i = 0; i < s2.length; i++) {
			System.out.println(i + "\t" + s2[i]);
		}
		
		return s2;
	}
}
