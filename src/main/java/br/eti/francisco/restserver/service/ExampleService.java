package br.eti.francisco.restserver.service;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.eti.francisco.restserver.entity.Game;
import br.eti.francisco.restserver.persistence.GameDao;

@Path("/example")
@Component
public class ExampleService {

	@Autowired
	private GameDao gameDao;

	@GET
	@PermitAll
	@Path("/listItems")
	@Produces("application/json")
	public Game listItems(){
		Game game;
		try {
			game = gameDao.consultar("1");
			return game;
		} catch (PersistenciaException e) {
			e.printStackTrace();
			return null;
		}
	}


}
