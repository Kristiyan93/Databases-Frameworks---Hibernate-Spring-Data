package usersystem.entities;

import javax.persistence.Entity;

@Entity(name = "users")
public class User {
    private Long id;
    private String userName;
    private String password;
    private String email;

}
