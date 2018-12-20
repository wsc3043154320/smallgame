package cn.test.test;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		int[] a = { 8, 2, 6, 3, 9, 0, 4, 1, 5, 7 };
		int[] b= {1,2,3,4,5,6,7,9,8};
		ArraySort(a);
		ArraySort(b);
	}

	 static void ArraySort(int[] a){
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
				System.out.println("\t\t" + Arrays.toString(a)+""+flag);
			}
			if (!flag) {
				System.out.println("½áÊø!!!!");
				break;
			}
		}

		System.out.println(Arrays.toString(a));
	}
}
