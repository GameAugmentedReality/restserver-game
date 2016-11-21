package br.eti.francisco.restserver.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.util.UtilLog;
import br.eti.francisco.restserver.entity.AccessKey;

import com.solutioin.jersey.oauth.security.JerseySecurityException;
import com.solutioin.jersey.oauth.security.KeyDao;

@Repository
public class AccessKeyDao extends PersistenciaJpa<AccessKey> implements KeyDao{

	private static final long serialVersionUID = 1L;

	@Autowired
	private GameDao gameDao;
	
	@Autowired
	private PlayerDao playerDao;
	
	private static Map<String, AccessKey> map = new HashMap<String, AccessKey>();
	
	@Override
	public String getSecretKey(String consumerKey) throws JerseySecurityException {
		try {
			AccessKey accessKey = findByConsumerKey(consumerKey);
			if(accessKey != null){
				map.put(consumerKey, accessKey);
				return accessKey.getSecretKey();
			}else{
				throw new JerseySecurityException("consumer key not found");
			}
		} catch (RuntimeException e) {
			UtilLog.getLog().error(e.getMessage(), e);
			throw new JerseySecurityException(e.getMessage(), e);
		}
	}

	public AccessKey findByConsumerKey(String consumerKey){
		try {
			Query query = em.createQuery("select a from AccessKey a where a.consumerKey = :consumerKey");
			query.setParameter("consumerKey", consumerKey);
			return (AccessKey) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public List<String> getRoles(String consumerKey) throws JerseySecurityException {
		List<String> roles = new ArrayList<String>();
		roles.add(map.get(consumerKey).getRole());
		return roles;
	}

}
