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
public class Score {

	@Id
	@GeneratedValue(generator="score_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="score_seq", sequenceName="score_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	@Column(nullable=false)
	private Integer score;

	@ManyToOne(optional=false)
	private Player player;

	@Column(nullable=false)
	private Date date;
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
