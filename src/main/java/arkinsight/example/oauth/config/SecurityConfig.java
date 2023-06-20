package arkinsight.example.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .authorizeHttpRequests((auth) -> {
                try {
                    auth
                        .anyRequest().authenticated()
                        .and()
                        .logout()
                        .logoutSuccessUrl("/welcome")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies()
                        .and()
                        .oauth2Login();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

        return http.build();
    }

}
