package com.yrwan19.java;

import java.net.URL;

//URL:һ��URL�����Ӧ�������ϵ�һ����Դ
public class TestURL {
	public static void main(String[] args) throws Exception {
		// 1.����url����
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
	}
}
