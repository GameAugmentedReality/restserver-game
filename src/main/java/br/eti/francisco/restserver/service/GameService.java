package br.eti.francisco.restserver.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.eti.francisco.restserver.dto.ProductDto;
import br.eti.francisco.restserver.entity.Product;
import br.eti.francisco.restserver.persistence.ProductDao;

@Path("/game")
@Component
public class GameService {

	@Autowired
	private ProductDao productDao;
	
	@Path("/product")
	@Produces("application/json")
	@RolesAllowed("GAME")
	@GET
	public List<ProductDto> listProducts(@Context SecurityContext securityContext){
		List<ProductDto> products = new ArrayList<ProductDto>();
		for(Product p : productDao.listByGameConsumerKey(securityContext.getConsumerKey())){
			products.add(ProductDto.fromPlayer(p));
		}
		return products;
	}

}
