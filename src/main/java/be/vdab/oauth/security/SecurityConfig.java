package be.vdab.oauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfig {
    @Bean
    public SecurityFilterChain geefRechten(HttpSecurity http) throws Exception {
        http.oauth2Login();
        http.authorizeRequests(requests -> requests.mvcMatchers("/").permitAll()
                .mvcMatchers("/beveiligd").authenticated());
        return http.build();
    }
}
