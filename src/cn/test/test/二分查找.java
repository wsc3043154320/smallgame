package cn.test.test;

import java.util.Arrays;

public class 二分查找 {
	public static void main(String[] args) {
		int[] a = { 8, 2, 6, 3, 9, 0, 4, 1, 5, 7 };
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println("下标是"+myBinarySearch(a, 8));
	}
	static int myBinarySearch(int[] a,int value) {
		int low=0;
		int high=a.length-1;
		while(low<=high) {
			int mid=(low+high)/2;
			System.out.println("mid"+mid);
			if(value==a[mid]) {
				return mid;
			}
			if(value>a[mid]) {
				low=mid+1;
				System.out.println("low"+low);
			}
			if(value<a[mid]) {
				high=mid-1;
			}
		}
		return -1;
	}
}
