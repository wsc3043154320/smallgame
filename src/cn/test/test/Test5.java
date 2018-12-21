package cn.test.test;

import java.util.Collection;

public class Test5 {
	public static void main(String[] args) {
		MyCollection my=new MyCollection();
		my.set("hehehe", 2);
		my.set("sdfgh", 4);
		System.out.println(my.get(2));
	}
	
}
	class MyCollection{
		Object[] objs=new Object[5];
		
		public void set(Object obj,int index) {
			objs[index]=obj;
		}
		public Object get(int index) {
			return objs[index];
		}
	} 