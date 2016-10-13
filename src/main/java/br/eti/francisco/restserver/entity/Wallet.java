package br.eti.francisco.restserver.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Wallet {

	@Id
	@GeneratedValue(generator="wallet_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="wallet_seq", sequenceName="wallet_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	@ManyToOne
	private Player player;
	
	private Integer balance;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getId() {
		return id;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
}
