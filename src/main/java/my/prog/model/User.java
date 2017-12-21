package my.prog.model;


import my.prog.annotations.Column;
import my.prog.annotations.ID;
import my.prog.annotations.Table;

@Table (name = "USERS")
public class User {
    @ID
    private long id;
    @Column ("firstname")
    private String name;
    @Column ("email")
    private String email;
    @Column ("password")
    private String password;
    @Column ("token")


    private String token;
    public User(){}
    public User (String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }


    public User (Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString () {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setToken (String token) {
        this.token = token;
    }
}
