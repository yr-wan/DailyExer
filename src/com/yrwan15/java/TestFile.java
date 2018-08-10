package com.yrwan15.java;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/*
 * java.io.File类
 * 1.与输入输出相关的类、接口都在java.io下
 * 2.File是一个类，有构造器，可以创建其对象，可表示文件及目录
 * 3.File对象与平台无关
 * 4.File中的方法，涉及到创建删除重命名，不能涉及内容，涉及内容的由流完成。
 * 5.File对象可以作为参数传递给流的构造函数
 */
public class TestFile {
	@Test
	public void test3() throws IOException{
		/*
		 * 文件操作相关:	
		 * createNewFile()
		 * delete()
		 * 目录操作相关:
		 * mkDir():创建单层目录
		 * mkDirs():创建多层目录
		 * list():String类型数组返回目录下的文件名
		 * listFiles():File类型数组返回目录下的文件
		 * 
		 */
		File file1 = new File("d:/io/HelloWorld1.txt");
		File file2 = new File("d:/io/test1");
		System.out.println(file1.delete());
		if(!file1.exists()){
			file1.createNewFile();
		}
		
		if(!file2.exists()){
			file2.mkdir();
		}
		
		
		
	}
	
	@SuppressWarnings("unused")
	@Test
	public void test2(){
		/*
		 * 文件检测:
		 * exists()
		 * canWrite()
		 * canRead()
		 * isFile()
		 * isDirectory()
		 * 获取常规文件信息:
		 * lastModified()
		 * length()
		 * 
		 */
		File file1 = new File("d:/io/HelloWorld1.txt");
		File file2 = new File("d:/io/test");
		System.out.println(file1.exists());
		System.out.println(file1.canWrite());
		System.out.println(file1.canRead());
		System.out.println(file1.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(new Date(file1.lastModified()));
		System.out.println(file1.length());
		System.out.println("-----------------------------");
	}
	
	@Test
	public void test1(){
		/*
		 * 访问文件名:
		 * getName()
		 * getPath()
		 * getAbsoluteFile()
		 * getAbsolutePath()
		 * getParent()
		 * boolean renameTo(File newName):原文件必须存在，新文件必须不存在
		 */
		File file1 = new File("d:/io/HelloWorld.txt");
		File file2 = new File("d:/io/test");
		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		System.out.println(file1.getAbsoluteFile());
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getParent());
		System.out.println();
		System.out.println(file2.getName());
		System.out.println(file2.getPath());
		System.out.println(file2.getAbsoluteFile());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getParent());
		
//		file1.renameTo(new File("d:/io/HelloWorld1.txt"));
		System.out.println("-----------------------------");
	}
}
