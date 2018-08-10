package com.yrwan14.java;

/*
 * 自定义注解
 */
public @interface MyAnnotation {
	String value() default "Hello";
}
