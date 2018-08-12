package com.yrwan15.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * BufferedInputStream缓冲流
 */
public class TestBuffered {
	@Test
	public void testBufferedReaderWriter() throws IOException{
		File file1 = new File("Test2.txt");
		File file2 = new File("TestOut2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file1));
		BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
//		char[] c = new char[20];
//		int len;
//		while ((len = br.read(c)) != -1) {
//			bw.write(c, 0, len);
//		}
		String str = new String();
		while ((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	@Test
	public void testBufferedInOut() throws IOException {
		/*
		 * BufferedInOut实现复制
		 */
		File file1 = new File("Test1.txt");
		File file2 = new File("TestOut1.txt");
		FileInputStream fis = new FileInputStream(file1);
		FileOutputStream fos = new FileOutputStream(file2);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] b = new byte[20];
		int len;
		while ((len = bis.read(b)) != -1) {
			bos.write(b, 0, len);
		}
		bos.close();
		bis.close();
	}
}
