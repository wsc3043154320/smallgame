package cn.test.test;

import java.io.File;

public class �ݹ��㷨��ӡĿ¼ {
	public static void main(String[] args) {
		File f=new File("E:\\����\\java\\java����300��\\03_�ɻ�С��Ŀ(java���źͶ�����ϰ)");
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
