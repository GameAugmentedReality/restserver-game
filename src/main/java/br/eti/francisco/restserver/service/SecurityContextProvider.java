package br.eti.francisco.restserver.service;

import java.lang.reflect.Type;

import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.api.core.HttpContext;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.oauth.server.OAuthServerRequest;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.server.impl.inject.AbstractHttpContextInjectable;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;

@Provider
public class SecurityContextProvider extends AbstractHttpContextInjectable<SecurityContext> implements InjectableProvider<Context, Type>{

	@Override
	public ComponentScope getScope() {
		return ComponentScope.PerRequest;
	}

	@Override
	public Injectable<SecurityContext> getInjectable(ComponentContext ic, Context a, Type c) {
		if (c.equals(SecurityContext.class)) {  
            return this;  
        }  
        return null;
	}

	@Override
	public SecurityContext getValue(HttpContext c) {
		OAuthServerRequest request = new OAuthServerRequest(c.getRequest());
		OAuthParameters params = new OAuthParameters();
		params.readRequest(request);
		return new SecurityContext(params.getConsumerKey());
	}



}
