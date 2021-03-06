package br.eti.francisco.restserver.persistence;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.eti.francisco.restserver.entity.Player;

@Repository("playerDao")
public class PlayerDao extends PersistenciaJpa<Player> {

	private static final long serialVersionUID = 1L;

	@Transactional
	public Player login(String email, String password){
		try {
			Query query = em.createQuery("select p from Player p where p.email = :email and p.password = :password");
			query.setParameter("email", email);
			query.setParameter("password", password);
			Player p = (Player) query.getSingleResult();
			p.getFriends().size();
			p.getItems().size();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Player findByEmail(String email){
		try {
			Query query = em.createQuery("select p from Player p where p.email = :email");
			query.setParameter("email", email);
			Player p = (Player) query.getSingleResult();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
