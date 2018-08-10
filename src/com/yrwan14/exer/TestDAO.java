package com.yrwan14.exer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*
 * 2. ����������� DAO<T>�������ж���һ��Map ��Ա������Map �ļ�Ϊ String ���ͣ�ֵΪ T ���͡�
 * 
 * �ֱ𴴽����·�����
 * public void save(String id,T entity)�� ���� T ���͵Ķ��� Map ��Ա������
 * T get(String id)���� map �л�ȡ id ��Ӧ�Ķ���
 * void update(String id,T entity)���滻 map ��keyΪid������,��Ϊ entity ����
 * List<T> list()������ map �д�ŵ����� T ����
 * void delete(String id)��ɾ��ָ�� id ����
 * 
 * ����һ�� User �ࣺ
 * ���������private��Ա������int���ͣ� id��age����String ���ͣ�name��
 * 
 * ���� DAO ��Ķ��� �ֱ������ save��get��update��list��delete ���������� User ����
 * ʹ�� Junit ��Ԫ��������в���
 * 
 */
public class TestDAO {
	@Test
	public void test() {
		DAO<User> d = new DAO<User>();
		d.save("100", new User(1, 20, "AA"));
		d.save("101", new User(2, 21, "BB"));
		d.save("102", new User(3, 22, "CC"));
		User u = d.get("102");
		System.out.println(u);
		System.out.println();
		
		List<User> list = d.list();
		for(User i :list){
			System.out.println(i);
		}
	}
}

class User {
	private int id;
	private int age;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

class DAO<T> {
	Map<String, T> map = new HashMap<>();

	public void save(String id, T entity) {
		map.put(id, entity);
	}

	public T get(String id) {
		return map.get(id);
	}

	public void update(String id, T entity) {
		map.put(id, entity);
	}

	public List<T> list() {
		List<T> list = new ArrayList<T>();
		for (T t : map.values()) {
			list.add(t);
		}
		return list;
	}

	public void delete(String id) {
		map.remove(id);
	}
}