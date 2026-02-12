package spring.security.chapter3.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.authorization.SingleResultAuthorizationManager.permitAll;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import spring.security.chapter3.filters.AuthenticationLoggingFilter;
import spring.security.chapter3.filters.CustomRequestFilter;
import spring.security.chapter3.service.DummyUserDetailsService;
import spring.security.chapter3.users.DummyUserEntity;
import spring.security.chapter3.users.SecurityDummyUser;

@Configuration
public class UserConfig{
    @Bean
    public UserDetailsService JDBCUserDetailsService(){
       
        var user = new SecurityDummyUser();
        user.setUser(new DummyUserEntity());


        return new DummyUserDetailsService(List.of(user));
     }

    @Bean
    public PasswordEncoder passwordEncoder(){
        
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.addFilterBefore(
                                new CustomRequestFilter(),
                                BasicAuthenticationFilter.class
                            )
            .addFilterAfter(
                                new AuthenticationLoggingFilter(),
                                BasicAuthenticationFilter.class
                            ).authorizeHttpRequests(
                                (auth)->auth.anyRequest().permitAll()
                            );

        return http.build();
        
    }
}