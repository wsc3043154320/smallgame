package cn.test.test;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		int[] a = { 8, 2, 6, 3, 9, 0, 4, 1, 5, 7 };
//		int[] b= {1,2,3,4,5,6,7,9,8};
		ArraySort(a);
//		ArraySort(b);
		getMax(a);

	}

	static void ArraySort(int[] a) {
		int temp = 0;
		boolean flag = true;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = false;
				}
			}
			if (flag) {
				System.out.println("½áÊø!!!!");
				break;
			}
		}System.out.println(Arrays.toString(a));
	}

	static void getMax(int[] a) {
		for (int j = 1; j >0; j++) {
			ArraySort(a);
			for (int i = a.length - 5; i < a.length; i++) {
				System.out.println(a[i]);
			}
		}
	}
}
