package com.yrwan19.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

// URL:ͳһ��Դ��λ����һ��URL�����Ӧ�������ϵ�һ����Դ
// ����ͨ��URL�Ķ����������Ӧ�ķ�����������Դ��ȡ�������ء���
public class TestURL {
	public static void main(String[] args) throws Exception {
		// 1.����ͨ��URL�Ķ����������Ӧ�ķ�����������Դ��ȡ�������ء���
		URL url = new URL("https://www.baidu.com/img/superlogo_c4d7df0a003d3db9b65e9ef0fe6da1ec.png");
		/*
		 * public String getProtocol() ��ȡ��URL��Э����
		 * public String getHost()     ��ȡ��URL��������
		 * public String getPort()     ��ȡ��URL�Ķ˿ں�
		 * public String getPath()     ��ȡ��URL���ļ�·��
		 * public String getFile()     ��ȡ��URL���ļ���
		 * public String getRef()      ��ȡ��URL���ļ��е����λ��
		 * public String getQuery()    ��ȡ��URL�Ĳ�ѯ��
		 */
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getFile());
		System.out.println(url.getRef());
		System.out.println(url.getQuery());

		// ��ν�����˵���Դ��ȡ����:openStream()
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream(new File("baidulogo.jpg"));
		byte[] b = new byte[1024];
		int len;
		while ((len = is.read(b)) != -1) {
			fos.write(b, 0, len);
		}
		fos.close();
		is.close();
	}
}
