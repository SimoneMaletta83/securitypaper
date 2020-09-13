package com.maletta.authmanager.clients;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CustomClientDetails implements ClientDetailsService {

    private static final String ADMITTED_CLIENT_ID = "mytestclient";
    private static final int ACCESS_TOKEN_TTL = 10;
    private static final int REFRESH_TOKEN_TTL = 100;


    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        if(clientId!=null && clientId.equals(ADMITTED_CLIENT_ID)) {
            BaseClientDetails client = new BaseClientDetails();
            //client id
            client.setClientId(ADMITTED_CLIENT_ID);
            //grants: what our client is allowed to do
            List<String> grants = new LinkedList<String>();
            grants.add("password");
            grants.add("refresh_token");
            client.setAuthorizedGrantTypes(grants);
            //scope: scope of the token c
            List<String> scopes = new LinkedList<String>();
            scopes.add("login");
            client.setScope(scopes);
            //TTL
            client.setAccessTokenValiditySeconds(ACCESS_TOKEN_TTL);
            client.setRefreshTokenValiditySeconds(REFRESH_TOKEN_TTL);
            return client;
        }
        else throw new ClientRegistrationException("Client ["+clientId+"] unadmitted");
    }
}
