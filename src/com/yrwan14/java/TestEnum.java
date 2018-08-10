package com.yrwan14.java;

/*
 * 1.自定义枚举类
 * 2.使用enum定义枚举类
 * 		常用方法:values(),valuesOf(String name)
 * 		实现接口:可让不用枚举类对象调用方法，执行的效果不一样
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
	SPRING("spring","春"){
		public void show(){
			System.out.println("枚举类Season2实现了info接口，春");
		}
	},
	SUMMER("summer","夏"){
		public void show(){
			System.out.println("枚举类Season2实现了info接口，夏");
		}
	},
	AUTUMN("autumn","秋"){
		public void show(){
			System.out.println("枚举类Season2实现了info接口，秋");
		}
	},
	WINTER("winter","冬"){
		public void show(){
			System.out.println("枚举类Season2实现了info接口，冬");
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


//枚举类
class Season1{
	//若类有属性，那么属性声明为：private final
	private final String seasonName;
	private final String seasonDesc;
	//此属性在构造器中赋值
	private Season1(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	//在类的内部创建枚举类的实例。声明为：public static final 
	public static final Season1 SPRING = new Season1("spring","春");
	public static final Season1 SUMMER = new Season1("summer","下");
	public static final Season1 AUTUMN = new Season1("autumn","秋");
	public static final Season1 WINTER = new Season1("winter","冬");
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