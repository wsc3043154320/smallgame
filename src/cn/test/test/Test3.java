package cn.test.test;

public class Test3 {
	public static void main(String[] args) {
		String a="s";
		String b="s";
		String c="s"+"s";
		String d="ss";
		System.out.println(a.equals(b));
		System.out.println(d==c);
		System.out.println(Integer.toHexString(a.hashCode()));
		System.out.println(Integer.toHexString(b.hashCode()));
	}
}
