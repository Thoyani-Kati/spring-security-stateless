package spring.security.chapter3.users;

import lombok.Data;

@Data
public class DummyUserEntity {
    String name;
    String password ;

    public DummyUserEntity(){
        this.name = "Thoyani";
        this.password = "1234";
        
    }

    public DummyUserEntity(String name , String password){
         this.name = name;
        this.password = password;
    }

}