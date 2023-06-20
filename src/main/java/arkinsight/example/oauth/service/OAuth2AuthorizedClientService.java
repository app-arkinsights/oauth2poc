package arkinsight.example.oauth.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class OAuth2AuthorizedClientService {

    private Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    private InMemoryOAuth2AuthorizedClientService clientService;

    private OAuth2AuthorizedClient client;

    private OAuth2AuthenticationToken oauthToken() {
        return (OAuth2AuthenticationToken) authentication;
    }

    public String getAccessToken() {
        client = clientService.loadAuthorizedClient(
                this.oauthToken().getAuthorizedClientRegistrationId(),
                this.oauthToken().getName());

        return client.getAccessToken().getTokenValue();
    }

}
