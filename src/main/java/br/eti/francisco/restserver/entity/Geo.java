package br.eti.francisco.restserver.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Geo {

	@Id
	@GeneratedValue(generator="geo_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="geo_seq", sequenceName="geo_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	@ManyToOne(optional=false)
	private Player player;
	
	@Column(nullable=false)
	private Date date;
	
	@Column(scale=10, precision=13)
	private BigDecimal latitude;
	
	@Column(scale=10, precision=13)
	private BigDecimal longitude;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Integer getId() {
		return id;
	}
	
	
}
