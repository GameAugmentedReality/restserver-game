package br.eti.francisco.restserver.service;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import br.eti.francisco.restserver.entity.Item;

@Path("/example")
@Component
public class ExampleService {


	@GET
	@PermitAll
	@Path("/listItems")
	@Produces("application/json")
	public Item listItems(){
		Item item = new Item();
		item.setName("Arco");
		item.setValue("120");
		return item;
	}


}
