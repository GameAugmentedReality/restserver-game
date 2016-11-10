package br.eti.francisco.restserver.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Game {
	
	@Id
	@GeneratedValue(generator="game_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="game_seq", sequenceName="game_seq", allocationSize=1, initialValue=1)
	private String id;
	
	@Column(nullable=false)
	private String name;
	
	private String description;
	
	@Column(nullable=false)
	private String uuid;
	
	@Column(nullable=false)
	private String author;
	
	@Column(nullable=false)
	private Date date;

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

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

}
