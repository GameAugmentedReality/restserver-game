package br.eti.francisco.restserver.persistence;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.eti.francisco.restserver.entity.Product;

@Repository
public class ProductDao extends PersistenciaJpa<Product> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Product> listByGameConsumerKey(String consumerKey){
		try {
			Query query = em.createQuery("select p from Product p join p.game g where g.accessKey.consumerKey = :consumerKey");
			query.setParameter("consumerKey", consumerKey);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
