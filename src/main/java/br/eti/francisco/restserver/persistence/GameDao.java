package br.eti.francisco.restserver.persistence;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.eti.francisco.restserver.entity.Game;

@Repository("gameDao")
public class GameDao extends PersistenciaJpa<Game> {

	private static final long serialVersionUID = 1L;

	public Game findByConsumerKey(String consumerKey){
		try {
			Query query = em.createQuery("select g from Game g where g.consumerKey = :consumerKey");
			query.setParameter("consumerKey", consumerKey);
			return (Game) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
