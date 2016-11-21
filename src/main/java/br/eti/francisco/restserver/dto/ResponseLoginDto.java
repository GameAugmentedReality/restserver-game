package br.eti.francisco.restserver.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.eti.francisco.restserver.entity.Player;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseLoginDto {

	private Integer id;
	
	private String gameKey;
	
	private String code;
	
	private String name;
	
	private String email;
	
	private String facebookId;

	public static ResponseLoginDto fromPlayer(Player player){
		ResponseLoginDto playerDto = new ResponseLoginDto();
		playerDto.code = player.getCode();
		playerDto.email = player.getEmail();
		playerDto.facebookId = player.getFacebookId();
		playerDto.gameKey = player.getGame().getUuid();
		playerDto.id = player.getId();
		playerDto.name = player.getName();
		return playerDto;
	}
	
	public Integer getId() {
		return id;
	}

	public String getGameKey() {
		return gameKey;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getFacebookId() {
		return facebookId;
	}
}
