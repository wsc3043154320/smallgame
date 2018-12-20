package cn.test.test;

import java.io.File;

public class 递归算法打印目录 {
	public static void main(String[] args) {
		File f=new File("E:\\资料\\java\\java基础300集\\03_飞机小项目(java入门和对象练习)");
		fileList(f, 0);
	}
	static void fileList(File file,int level) {
		for (int i = 0; i <level; i++) {
			System.out.print("\t-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()) {
			File[] file1=file.listFiles();
			for (File file2 : file1) {
				fileList(file2,level+1);
			}
		}
	}
}
