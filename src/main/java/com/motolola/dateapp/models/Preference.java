package com.motolola.dateapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "preference")
public class Preference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_preference", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "preference_id"))
	private List<User> users = new ArrayList<>();
	
	public Preference(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Preference() {

	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	@Override
	public String toString() {
		return "Preference [id=" + id + ", name=" + name + ", description=" + description + ", users=" + users + "]";
	}
	

}
