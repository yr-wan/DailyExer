package com.yrwan14.exer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*
 * 2. 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 * 
 * 分别创建以下方法：
 * public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 * T get(String id)：从 map 中获取 id 对应的对象
 * void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 * List<T> list()：返回 map 中存放的所有 T 对象
 * void delete(String id)：删除指定 id 对象
 * 
 * 定义一个 User 类：
 * 该类包含：private成员变量（int类型） id，age；（String 类型）name。
 * 
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试
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