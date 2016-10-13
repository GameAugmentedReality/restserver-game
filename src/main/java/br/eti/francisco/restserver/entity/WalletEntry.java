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
public class WalletEntry {
	
	@Id
	@GeneratedValue(generator="walletentry_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="walletentry_seq", sequenceName="walletentry_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	@Column(nullable=false)
	private Date date;
	
	@Column(nullable=false)
	private Integer value;

	@ManyToOne(optional=false)
	private Wallet wallet;
	
	@Column(nullable=false)
	private String description;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
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

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
}
