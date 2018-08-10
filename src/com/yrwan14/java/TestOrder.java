package com.yrwan14.java;

import java.util.ArrayList;
import java.util.List;

/*
 * 自定义泛型练习
 */
public class TestOrder<T> {
	private String name;
	private int id;
	private T t;
	List<T> list = new ArrayList<T>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public TestOrder() {
		super();
	}
	public TestOrder(String name, int id, T t, List<T> list) {
		super();
		this.name = name;
		this.id = id;
		this.t = t;
		this.list = list;
	}
	@Override
	public String toString() {
		return "TestOrder [name=" + name + ", id=" + id + ", t=" + t + ", list=" + list + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestOrder other = (TestOrder) obj;
		if (id != other.id)
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		return true;
	}
	
}
