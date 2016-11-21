package br.eti.francisco.restserver.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Player {

	@Id
	@GeneratedValue(generator="player_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="player_seq", sequenceName="player_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	@ManyToOne(optional=false)
	private Game game;
	
	@Column(nullable=false)
	private String code = RandomText.getRandom(10);
	
	@Column(nullable=false)
	private String name;
	
	private String password;
	
	private String email;
	
	private String facebookId;

	@OneToMany
	@JoinColumn(name="player_id")
	private List<Item> items = new ArrayList<Item>();
	
	@ManyToMany
	private List<Player> friends = new ArrayList<Player>();
	
	@ManyToOne(optional=false, cascade=CascadeType.ALL)
	private AccessKey accessKey = new AccessKey("PLAYER");
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public Integer getId() {
		return id;
	}

	public List<Player> getFriends() {
		return friends;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Item> getItems() {
		return items;
	}

	public AccessKey getAccessKey() {
		return accessKey;
	}
	
	
}
