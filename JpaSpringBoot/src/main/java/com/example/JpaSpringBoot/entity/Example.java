package com.example.JpaSpringBoot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/**
 * The persistent class for the EXAMPLE database table.
 * 
 */
@Entity
@Table(name="EXAMPLE")
@NamedQuery(name="selectQuery", query="SELECT e FROM Example e where e.name='Rohit'")
public class Example implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="NAME")
	private String name;

	@Column(name="AGE")
	private Integer age;

	@Column(name="LOCATION")
	private String location;
	
	@Column(name="STATUS")
	private Integer status;

	public Example() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Example [name=" + name + ", age=" + age + ", location=" + location + ", status=" + status + "]";
	}
	
	// Status change after consume
	
/*	@Consumed
    public void afterConsume()
    {
        setStatus(1);
    }
	*/

}