package br.eti.francisco.restserver.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ScoreHistory {

	@Id
	private Integer id;
	
	@ManyToOne
	private Player player;
	
	private Date date;
	
	private Integer score;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}
}
