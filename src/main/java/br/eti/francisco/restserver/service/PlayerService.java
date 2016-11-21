package br.eti.francisco.restserver.service;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.eti.francisco.restserver.dto.ResponseLoginDto;
import br.eti.francisco.restserver.persistence.PlayerDao;

@Path("/player")
@Component
public class PlayerService {

	@Autowired
	private PlayerDao playerDao;
	
	@Path("/login")
	@Produces("application/json")
	@RolesAllowed("PLAYER")
	@GET
	public ResponseLoginDto login(@Context SecurityContext securityContext){
		return ResponseLoginDto.fromPlayer(playerDao.findByEmail(securityContext.getConsumerKey()));
	}

}
