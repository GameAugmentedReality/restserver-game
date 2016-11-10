package br.eti.francisco.restserver.persistence;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.eti.francisco.restserver.entity.Game;

@Repository("gameDao")
public class GameDaoJpa extends PersistenciaJpa<Game> implements GameDao{

}
