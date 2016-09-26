package br.eti.francisco.restserver.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tiro {

	private String nome;
	
	private long momento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getMomento() {
		return momento;
	}

	public void setMomento(long momento) {
		this.momento = momento;
	}

	
}
