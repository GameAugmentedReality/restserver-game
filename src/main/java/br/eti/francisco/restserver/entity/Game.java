package br.eti.francisco.restserver.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(generator="game_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="game_seq", sequenceName="game_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	private String description;
	
	@Column(nullable=false)
	private String uuid = UUID.randomUUID().toString();
	
	@Column(nullable=false)
	private String author;
	
	@Column(nullable=false)
	private Date date = new Date();

	@ManyToOne(optional=false, cascade=CascadeType.ALL)
	private AccessKey accessKey = new AccessKey("GAME");

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUuid() {
		return uuid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public Integer getId() {
		return id;
	}

	public AccessKey getAccessKey() {
		return accessKey;
	}

}
