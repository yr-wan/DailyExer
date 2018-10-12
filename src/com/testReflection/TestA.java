package com.testReflection;

import java.lang.reflect.Field;

public class TestA {
	public static void main(String[] args) throws Exception {
		A a1=new A();
		A a2=new A();
        System.out.println("判断a1.tempString与a2.tempString是否相同!");
        System.out.println(a1.tempString==a2.tempString);
        System.out.println("########################");
        System.out.println("判读a1.tempString的值与\"wide world\"是否相同");
        System.out.println(a1.tempString=="wide world");
        System.out.println("#####################");
        
        char[] c = new char[]{'N','i','c','e','!','!'};
		Field field = a1.tempString.getClass().getDeclaredField("value");
		field.setAccessible(true);
		field.set(a1.tempString, c);
		System.out.println(a1.tempString);
        
        
//        String str = "HelloWorld";
//        char[] c = new char[]{'N','i','c','e','!','!'};
//        System.out.println(str + "::" + str.hashCode());// hello::99162322
//        Class<?> clazz = str.getClass();
//        String str2 = (String) clazz.newInstance();
//        System.out.println(str2 + "::" + str.hashCode());// aaaaaaaa::99162322
//        Field value = clazz.getDeclaredField("value");
//        value.setAccessible(true);
//        value.set(str2, c);
//        System.out.println(str + "::" + str.hashCode());// aaaaaaaa::99162322
//        System.out.println(str2 + "::" + str.hashCode());// aaaaaaaa::99162322
	}
}

class A {
	public final String tempString = "wide world";

	public String getTempString() {
		return tempString;
	}
}