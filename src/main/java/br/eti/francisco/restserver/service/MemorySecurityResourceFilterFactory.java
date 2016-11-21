package br.eti.francisco.restserver.service;

import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.eti.francisco.restserver.persistence.AccessKeyDao;

import com.solutioin.jersey.oauth.security.KeyDao;
import com.solutioin.jersey.oauth.security.SecurityResourceFilterFactory;

@Component
@Provider
public class MemorySecurityResourceFilterFactory extends SecurityResourceFilterFactory{

   @Autowired
   private AccessKeyDao accessKeyDao;

   
   @Override
   public KeyDao getChaveAcessoDao() {
      return accessKeyDao;
   }

}