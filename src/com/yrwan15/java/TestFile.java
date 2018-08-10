package com.yrwan15.java;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/*
 * java.io.File��
 * 1.�����������ص��ࡢ�ӿڶ���java.io��
 * 2.File��һ���࣬�й����������Դ�������󣬿ɱ�ʾ�ļ���Ŀ¼
 * 3.File������ƽ̨�޹�
 * 4.File�еķ������漰������ɾ���������������漰���ݣ��漰���ݵ�������ɡ�
 * 5.File���������Ϊ�������ݸ����Ĺ��캯��
 */
public class TestFile {
	@Test
	public void test3() throws IOException{
		/*
		 * �ļ��������:	
		 * createNewFile()
		 * delete()
		 * Ŀ¼�������:
		 * mkDir():��������Ŀ¼
		 * mkDirs():�������Ŀ¼
		 * list():String�������鷵��Ŀ¼�µ��ļ���
		 * listFiles():File�������鷵��Ŀ¼�µ��ļ�
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
		 * �ļ����:
		 * exists()
		 * canWrite()
		 * canRead()
		 * isFile()
		 * isDirectory()
		 * ��ȡ�����ļ���Ϣ:
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
		 * �����ļ���:
		 * getName()
		 * getPath()
		 * getAbsoluteFile()
		 * getAbsolutePath()
		 * getParent()
		 * boolean renameTo(File newName):ԭ�ļ�������ڣ����ļ����벻����
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
