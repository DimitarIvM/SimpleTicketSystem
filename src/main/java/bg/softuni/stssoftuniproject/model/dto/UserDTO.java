package bg.softuni.stssoftuniproject.model.dto;

import bg.softuni.stssoftuniproject.model.enums.RolesEnum;

import java.util.List;

public class UserDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<RolesEnum> getRole() {
//        return roles;
//    }
//
//    public void setRole(List<RolesEnum> roles) {
//        this.roles = roles;
//    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;
    private String email;
//    private List<RolesEnum> roles;
    private String lastName;
}
