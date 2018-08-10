package com.yrwan14.java;

/*
 * 1.�Զ���ö����
 * 2.ʹ��enum����ö����
 * 		���÷���:values(),valuesOf(String name)
 * 		ʵ�ֽӿ�:���ò���ö���������÷�����ִ�е�Ч����һ��
 */
public class TestEnum {
	public static void main(String[] args) {
//		Season1 spring = Season1.SPRING;
//		System.out.println(spring);
//		System.out.println(spring.getSeasonDesc());
		
		//values()
		Season2[] seasons = Season2.values();
		for (Season2 season2 : seasons) {
			System.out.println(season2);
		}
		System.out.println();
		
		//valuesOf(String name)
		String str = "SPRING";
		System.out.println(Season2.valueOf(str));
		
		Season2.SPRING.show();
		
	}
}
interface Info{
	void show();
}


//enum
enum Season2 implements Info{
	SPRING("spring","��"){
		public void show(){
			System.out.println("ö����Season2ʵ����info�ӿڣ���");
		}
	},
	SUMMER("summer","��"){
		public void show(){
			System.out.println("ö����Season2ʵ����info�ӿڣ���");
		}
	},
	AUTUMN("autumn","��"){
		public void show(){
			System.out.println("ö����Season2ʵ����info�ӿڣ���");
		}
	},
	WINTER("winter","��"){
		public void show(){
			System.out.println("ö����Season2ʵ����info�ӿڣ���");
		}
	};
	
	private final String seasonName;
	private final String seasonDesc;
	
	private Season2(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	
	
}


//ö����
class Season1{
	//���������ԣ���ô��������Ϊ��private final
	private final String seasonName;
	private final String seasonDesc;
	//�������ڹ������и�ֵ
	private Season1(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	//������ڲ�����ö�����ʵ��������Ϊ��public static final 
	public static final Season1 SPRING = new Season1("spring","��");
	public static final Season1 SUMMER = new Season1("summer","��");
	public static final Season1 AUTUMN = new Season1("autumn","��");
	public static final Season1 WINTER = new Season1("winter","��");
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
}