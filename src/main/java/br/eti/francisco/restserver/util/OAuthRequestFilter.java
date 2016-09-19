package br.eti.francisco.restserver.util;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.util.UtilLog;
import br.eti.francisco.restserver.entity.ChaveAcesso;
import br.eti.francisco.restserver.persistence.ChaveAcessoDao;

import com.sun.jersey.oauth.server.OAuthServerRequest;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthSecrets;
import com.sun.jersey.oauth.signature.OAuthSignature;
import com.sun.jersey.oauth.signature.OAuthSignatureException;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;

public class OAuthRequestFilter implements ResourceFilter, ContainerRequestFilter {

   private static final Map<String, ChaveAcesso> MAPA_CHAVES = new HashMap<String, ChaveAcesso>();

   private ChaveAcessoDao chaveAcessoDao;
   
   private SecurityRole securityRole;

   public OAuthRequestFilter(ChaveAcessoDao chaveAcessoDao, SecurityRole securityRole) {
      this.chaveAcessoDao = chaveAcessoDao;
      this.securityRole = securityRole;
   }

   private synchronized ChaveAcesso consultarChaveAcesso(String consumerKey){
      try {
         ChaveAcesso chaveAcesso = chaveAcessoDao.consultar(consumerKey);
         if(chaveAcesso != null){
            MAPA_CHAVES.put(consumerKey, chaveAcesso);
            chaveAcesso.setTimestamp(System.currentTimeMillis());
            return chaveAcesso;
         }else{
            return null;
         }
      } catch (PersistenciaException e) {
         UtilLog.getLog().error(e.getMessage(), e);
         return null;
      }
   }

   private ChaveAcesso getSecretKey(String consumerKey){
      ChaveAcesso chave = MAPA_CHAVES.get(consumerKey);
      if(chave != null && (System.currentTimeMillis() - chave.getTimestamp() < 600000)){
         return chave;
      }else{
         ChaveAcesso chaveAcesso = consultarChaveAcesso(consumerKey);
         return chaveAcesso != null ? chaveAcesso : null;
      }
   }

   @Override
   public ContainerRequest filter(ContainerRequest request) {
      OAuthServerRequest oauthRequest = new OAuthServerRequest(request);
      OAuthParameters params = new OAuthParameters();
      params.readRequest(oauthRequest);

      String consumerKey = params.getConsumerKey();
      if(consumerKey != null){
         ChaveAcesso chave = getSecretKey(consumerKey);
         if(chave != null){
            try {
               autenticar(oauthRequest, params, chave);
               autorizar(chave);
            } catch (WebApplicationException e) {
               MAPA_CHAVES.remove(consumerKey);
               throw e;
            }
         }else{
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
         }
      }else{
         throw new WebApplicationException(Response.Status.UNAUTHORIZED);
      }

      return request;
   }

   private void autorizar(ChaveAcesso chave) {
      if(securityRole != null){
         if(securityRole.isDenyAll()){
            throw new WebApplicationException(Response.Status.FORBIDDEN);
         }else{
            boolean contemRole = contemRole(chave);
            if(!contemRole){
               throw new WebApplicationException(Response.Status.FORBIDDEN);
            }
         }
      }
   }

   private boolean contemRole(ChaveAcesso chave) {
      for(String rolePermitida : securityRole.getRolesAllowed()){
         for(String roleUsuario : chave.getRolesArray()){
            if(rolePermitida.equals(roleUsuario)){
               return true;
            }
         }
      }
      return false;
   }

   private void autenticar(OAuthServerRequest oauthRequest, OAuthParameters params, ChaveAcesso chave) {
      OAuthSecrets secrets = new OAuthSecrets().consumerSecret(chave.getSecretKey());
      try {
         if (!OAuthSignature.verify(oauthRequest, params, secrets)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
         } 
      } catch(RuntimeException e) {
         throw new WebApplicationException(Response.Status.UNAUTHORIZED);
      } catch (OAuthSignatureException e) {
         throw new WebApplicationException(Response.Status.UNAUTHORIZED);
      }
   }

   @Override
   public ContainerRequestFilter getRequestFilter() {
      return this;
   }

   @Override
   public ContainerResponseFilter getResponseFilter() {
      return null;
   }

}
