package br.eti.francisco.restserver.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.eti.francisco.restserver.entity.Game;
import br.eti.francisco.restserver.entity.Player;
import br.eti.francisco.restserver.persistence.GameDao;
import br.eti.francisco.restserver.persistence.PlayerDao;

@Component
public class Initializer {

	@Autowired
	private GameDao gameDao;
	
	@Autowired
	private PlayerDao playerDao;
	
	@PostConstruct
	public void init(){
		List<Game> games = gameDao.listar();
		if(games.isEmpty()){
			Game game = new Game();
			game.setAuthor("Test");
			game.setDescription("Game Test");
			game.setName("Test");
			gameDao.incluir(game);
			
			Player player = new Player();
			player.setEmail("t@t.com");
			player.setGame(game);
			player.setName("Player Test");
			player.setPassword("123456");
			playerDao.incluir(player);
		}
	}
	
}
