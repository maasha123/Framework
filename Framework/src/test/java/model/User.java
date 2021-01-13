package model;

import java.util.Objects;

public class User {
    private String username;
    private String lastname;
    private String patronymic;
    private String password;
    private String email;

    public User(String username, String lastname, String patronymic, String password, String email) {
        this.username = username;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.password = password;
        this.email = email;
    }

   // public User(String username, String password, String phoneNumber, String email) {
   //     this.username = username;
   //     this.password = password;
   //     this.phoneNumber = phoneNumber;
   //     this.email = email;
   // }

   // public User(String username, String password) {
   //     this.username = username;
   //     this.password = password;
   // }

    public String getUsername() {
        return username;
    }

    public String getLastName() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPassword() {
        return password;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "User(" +
                "username= '" + username+ "'" +
                ", password= '" + password + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof User)) return false;
        User user=(User) o;
        return Objects.equals(getUsername(),user.getUsername()) &&
                Objects.equals(getPassword(),user.getPassword());
    }
}
