package br.eti.francisco.restserver.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class AccessKey {

	@Id
	@GeneratedValue(generator="accesskey_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="accesskey_seq", sequenceName="accesskey_seq", allocationSize=1, initialValue=1)
	private Integer id;
	
	@Column(nullable=false, unique=true)
	private String consumerKey = RandomText.getRandom(15);

	private String secretKey = RandomText.getRandom(15);

	@Column(nullable=false)
	private String role;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date();

	public AccessKey() {

	}

	public AccessKey(String role){
		this.role = role;
	}
	
	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDate() {
		return date;
	}

	public Integer getId() {
		return id;
	}


}
