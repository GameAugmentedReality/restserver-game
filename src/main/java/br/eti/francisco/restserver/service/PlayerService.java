package br.eti.francisco.restserver.service;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.eti.francisco.restserver.entity.Player;
import br.eti.francisco.restserver.persistence.PlayerDao;

@Path("/player")
@Component
public class PlayerService {

	@Autowired
	private PlayerDao playerDao;
	
	@Path("/login/{email}/{password}")
	@Produces("application/json")
	@PermitAll
	@GET
	public Player login(@PathParam("email") String email, @PathParam("password")String password){
		return playerDao.login(email, password);
	}
}
