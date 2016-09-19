package br.eti.francisco.restserver.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.eti.francisco.restserver.persistence.ChaveAcessoDao;

import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.spi.container.ResourceFilter;
import com.sun.jersey.spi.container.ResourceFilterFactory;

@Component
@Provider
public class SecurityResourceFilterFactory implements ResourceFilterFactory {

   @Autowired
   private ChaveAcessoDao chaveAcessoDao;

   
   @Override
   public List<ResourceFilter> create(AbstractMethod am) {
      List<ResourceFilter> filters = new ArrayList<ResourceFilter>();

      if (!am.isAnnotationPresent(PermitAll.class)) {
         SecurityRole securityRole = null;
         
         if (am.isAnnotationPresent(DenyAll.class)){
            securityRole = new SecurityRole();
         }else{
            RolesAllowed ra = am.getAnnotation(RolesAllowed.class);
            if (ra != null){
               securityRole = new SecurityRole(ra.value());
            }
         }
         
         filters.add(new OAuthRequestFilter(chaveAcessoDao, securityRole));
      }

      return filters;
   }
   
   

}