package br.eti.francisco.restserver.persistence;

import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.eti.francisco.restserver.entity.Player;

public interface PlayerDao extends Persistencia<Player>{

	Player login(String email, String password);
}
