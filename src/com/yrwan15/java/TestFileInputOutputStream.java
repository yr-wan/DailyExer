package com.yrwan15.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/*
 * 1.流的分类：字节流 字符流(处理文本文件)
 * 1.IO流的体系：
 * 抽象基类		      节点流（文件流）                              		                                          缓冲流（处理流的一种,可以提升文件操作的效率）
 * InputStream	  FileInputStream(int read(byte[] b))	  BufferedInputStream(int read(byte[] b))
 * OutputStream	  FileOutputStream(void write(b,0,len))	  BufferedOutputStream(flush())  (void write(b,0,len))
 * Reader		  FileReader(int read(char[] c))		  BufferedReader(readLine())  (int read(char[] c))或String readLine()
 * Writer		  FileWriter(void write(c,0,len))		  BufferedWriter(flush()) (void write(c,0,len)或void write(String str))
 */
public class TestFileInputOutputStream {
	// 复制
	@Test
	public void testFileInAndOutputStream() {
		// 创建File类的对象
		File file1 = new File("Test1.txt");
		File file2 = new File("TestOut1.txt");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			byte[] b = new byte[10];
			int len;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileOutputStream1() {
		// 创建File类的对象
		File file = new File("TestOut1.txt");
		// 创建FileOutputStream类的对象
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			// 调用FileOutputStream的方法，写入文件
			fos.write(new String("I Love China!").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					// 关闭流
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileInputStream3() {
		File file = new File("Test1.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[20];// 每次读取数据写入的数组
			int len;// 每次读入到byte中的长度
			while ((len = fis.read(b)) != -1) {
				for (int i = 0; i < len; i++) {
					System.out.print((char) b[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 遇到异常时能确保流的关闭
	@Test
	public void testFileInputStream2() {
		File file = new File("Test1.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print((char) b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 遇到异常时不能确保流的关闭
	@Test
	public void testFileInputStream1() throws IOException {
		// 创建File类的对象
		File file = new File("Test1.txt");
		// 创建FileInputStream类的对象
		FileInputStream fis = new FileInputStream(file);
		// 调用FileInputStream的方法，读取文件
		int b;
		while ((b = fis.read()) != -1) {
			System.out.print((char) b);
		}
		// 关闭流
		fis.close();
	}
}
