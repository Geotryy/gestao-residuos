package br.com.fiap.gestao_residuos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User.builder()
                .username("geo")
                .password(encoder.encode("senha123"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST,   "/pontos-coleta/**").hasRole("ADMIN")
                        .requestMatchers(                   "/pontos-coleta/**").hasAnyRole("USER","ADMIN")

                        .requestMatchers(HttpMethod.GET,    "/reciclaveis/**").permitAll()                     // público
                        .requestMatchers(HttpMethod.POST,   "/reciclaveis/**").hasAnyRole("USER","ADMIN")     // USER & ADMIN
                        .requestMatchers(HttpMethod.PUT,    "/reciclaveis/**").hasAnyRole("USER","ADMIN")     // USER & ADMIN
                        .requestMatchers(HttpMethod.DELETE, "/reciclaveis/**").hasRole("ADMIN")               // só ADMIN

                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
