package br.eti.francisco.restserver.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.collections.iterators.ArrayListIterator;
import org.springframework.stereotype.Component;

@Path("/multiplayer")
@Component
public class MultiplayerService {

	private List<Tiro> tiros = new ArrayList<Tiro>();
	
	@GET
	@PermitAll
	@Path("/atirar/{nome}")
	public void atirar(@PathParam("nome") String nome){
		System.out.println(nome + " atirou");
		Tiro tiro = new Tiro();
		tiro.setNome(nome);
		tiro.setMomento(System.currentTimeMillis());
		tiros.add(tiro);
	}

	@GET
	@PermitAll
	@Path("/consultar/{instante}")
	@Produces("application/json")
	public List<Tiro> consultar(@PathParam("instante") String instante){
		List<Tiro> result = new ArrayList<Tiro>();
		long inst = Long.parseLong(instante);
		for(Tiro tiro : tiros){
			if(tiro.getMomento() > inst){
				result.add(tiro);
			}
		}
		return result;
	}
}
