package br.eti.francisco.restserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(generator="item_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="item_seq", sequenceName="item_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	@ManyToOne(optional=false)
	private Product product;

	@Column(nullable=false)
	private Integer quantity;
	
	private boolean inventory;
	
	private String characteristics;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public boolean isInventory() {
		return inventory;
	}

	public void setInventory(boolean inventory) {
		this.inventory = inventory;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
}
