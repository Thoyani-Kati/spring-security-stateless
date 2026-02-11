package spring.security.chapter3.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import spring.security.chapter3.users.SecurityDummyUser;

public class DummyUserDetailsService implements UserDetailsService{
    public final List<SecurityDummyUser> users;
    public DummyUserDetailsService(List<SecurityDummyUser> users){
        this.users=users;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return users.stream().filter(
                                    dummyUser -> dummyUser.getUsername().equals(username)
                                    ).findFirst().get();
    }
    
}
