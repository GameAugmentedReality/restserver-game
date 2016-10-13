package br.eti.francisco.restserver.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemHistory {

	@Id
	@GeneratedValue(generator="itemhistory_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="itemhistory_seq", sequenceName="itemhistory_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	@ManyToOne(optional=false)
	private Item item;
	
	@Column(nullable=false)
	private Integer quantity;
	
	@Column(nullable=false)
	private Date date;
	
	@Column(nullable=false)
	private String description;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
}
