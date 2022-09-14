package com.sk.blog.springbootblogrestapi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name="users",
 uniqueConstraints = {@UniqueConstraint(columnNames = {"userName"}),
		 @UniqueConstraint(columnNames = {"email"})})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String userName;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="user_roles",
	joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id"))
	private Set<Role> roles;
}
