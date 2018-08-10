package com.yrwan15.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/*
 * 1.���ķ��ࣺ�ֽ��� �ַ���(�����ı��ļ�)
 * 1.IO������ϵ��
 * �������		      �ڵ������ļ�����                              		                                          ����������������һ��,���������ļ�������Ч�ʣ�
 * InputStream	  FileInputStream(int read(byte[] b))	  BufferedInputStream(int read(byte[] b))
 * OutputStream	  FileOutputStream(void write(b,0,len))	  BufferedOutputStream(flush())  (void write(b,0,len))
 * Reader		  FileReader(int read(char[] c))		  BufferedReader(readLine())  (int read(char[] c))��String readLine()
 * Writer		  FileWriter(void write(c,0,len))		  BufferedWriter(flush()) (void write(c,0,len)��void write(String str))
 */
public class TestFileInputOutputStream {
	// ����
	@Test
	public void testFileInAndOutputStream() {
		// ����File��Ķ���
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
		// ����File��Ķ���
		File file = new File("TestOut1.txt");
		// ����FileOutputStream��Ķ���
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			// ����FileOutputStream�ķ�����д���ļ�
			fos.write(new String("I Love China!").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					// �ر���
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
			byte[] b = new byte[20];// ÿ�ζ�ȡ����д�������
			int len;// ÿ�ζ��뵽byte�еĳ���
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

	// �����쳣ʱ��ȷ�����Ĺر�
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

	// �����쳣ʱ����ȷ�����Ĺر�
	@Test
	public void testFileInputStream1() throws IOException {
		// ����File��Ķ���
		File file = new File("Test1.txt");
		// ����FileInputStream��Ķ���
		FileInputStream fis = new FileInputStream(file);
		// ����FileInputStream�ķ�������ȡ�ļ�
		int b;
		while ((b = fis.read()) != -1) {
			System.out.print((char) b);
		}
		// �ر���
		fis.close();
	}
}
