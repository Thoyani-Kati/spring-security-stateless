package spring.security.chapter3.users;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class DummyUser implements UserDetails {
    String name;
    String password ;

    public DummyUser(){
        this.name = "Thoyani";
        this.password = "1234";
        // var user = User
        // .withUsername("tHOY")
        // .password("asd")
        // .authorities(()->"READ")
        // .accountExpired(false)
        // .disabled(true)
        // .build();
        // user=this;
    }

    public DummyUser(String name , String password){
         this.name = name;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
    return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
