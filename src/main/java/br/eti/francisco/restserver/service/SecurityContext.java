package br.eti.francisco.restserver.service;

public class SecurityContext {
	
	private String consumerKey;
	
	public SecurityContext(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

}
