package com.yrwan15.java;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * 字符流的输入与输出
 */
public class TestFileReaderFileWriter {
	// 复制
	@Test
	public void testFileReaderWriter() {
		File file1 = new File("Test2.txt");
		File file2 = new File("TestOut2.txt");
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(file1);
			fw = new FileWriter(file2);
			char[] c = new char[24];
			int len;
			while ((len = fr.read(c)) != -1) {
				fw.write(c, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileWriter() {
		File file = new File("TestOut2.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(new String("我爱中国！"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileReader() {
		File file = new File("Test2.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			char[] c = new char[24];
			int len;
			while ((len = fr.read(c)) != -1) {
				String str = new String(c, 0, len);
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
