package com.maletta.authmanager.configuration;

import com.maletta.authmanager.clients.CustomClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

@Configuration
public class AuthManagerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private CustomClientDetails clientDetailsService;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        clients.withClientDetails(clientDetailsService);
    }

}
