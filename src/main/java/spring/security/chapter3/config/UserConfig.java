package spring.security.chapter3.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import spring.security.chapter3.service.DummyUserDetailsService;
import spring.security.chapter3.users.DummyUserEntity;
import spring.security.chapter3.users.SecurityDummyUser;

@Configuration
public class UserConfig{
    @Bean
    public UserDetailsService dummyUserDetailsService(){
       
        var user = new SecurityDummyUser();
        user.setUser(new DummyUserEntity());


        return new DummyUserDetailsService(List.of(user));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        
        return NoOpPasswordEncoder.getInstance();
    }
}