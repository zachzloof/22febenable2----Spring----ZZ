package com.qa.demo.domain;

public class Fighter {
	
	//attributes
	private Integer id;
	private String name;
	private Integer age;
	private Integer height;
	private Integer reach;
	
	//constructors
	
	public Fighter(Integer id, String name, Integer age, Integer height, Integer reach) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
		this.reach = reach;
	}
	public Fighter() {
		super();
	}
	
	//getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getReach() {
		return reach;
	}
	public void setReach(Integer reach) {
		this.reach = reach;
	}
	
	
	//to string method
	@Override
	public String toString() {
		return "Fighter [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + ", reach=" + reach
				+ "]";
	}
	
	

}
